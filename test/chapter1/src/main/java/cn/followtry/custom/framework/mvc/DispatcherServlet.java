package cn.followtry.custom.framework.mvc;

import cn.followtry.custom.framework.base.HelperLoader;
import cn.followtry.custom.framework.core.BeanHelper;
import cn.followtry.custom.framework.core.ConfigHelper;
import cn.followtry.custom.framework.core.ControllerHelper;
import cn.followtry.custom.framework.core.ReflectionUtil;
import cn.followtry.custom.framework.util.CodecUtils;
import cn.followtry.custom.framework.util.JsonUtils;
import cn.followtry.custom.framework.util.StreamUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by followtry on 2017/4/13.
 */
@WebServlet(urlPatterns="/*", loadOnStartup=0)
public class DispatcherServlet extends HttpServlet {

	private static final Logger LOGGER=LoggerFactory.getLogger(DispatcherServlet.class);

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		//初始化相关的helper类
		HelperLoader.init();
		ServletContext servletContext=servletConfig.getServletContext();
		ServletRegistration jspServlet=servletContext.getServletRegistration("jsp");
		jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");

		//注册处理静态资源的默认Servlet
		ServletRegistration staticServlet=servletContext.getServletRegistration("default");
		staticServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");

		showInfo(servletContext);

	}

	private void showInfo(ServletContext servletContext) {
		Map<String, ? extends ServletRegistration> servletRegistrations=servletContext.getServletRegistrations();
		LOGGER.info("打印显示servletRegistrations信息");
		for (Map.Entry<String, ? extends ServletRegistration> registration : servletRegistrations.entrySet()) {
			LOGGER.info(registration.getKey() + ":" + registration.getValue());
		}
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reqMethod=req.getMethod().toLowerCase();
		String pathInfo=req.getPathInfo();

		Handler handler=ControllerHelper.getHandler(reqMethod, pathInfo);
		if (handler != null) {
			Class<?> controllerClass=handler.getControllerClass();
			Object bean=BeanHelper.getBean(controllerClass);

			Param param=getParams(req);

			Method actionMethod=handler.getActionMethod();
			Object result;
			try {
				result=ReflectionUtil.invokeMethod(bean, actionMethod, param);
			} catch(Exception e) {
				LOGGER.error("invoke exception", e);
				throw new RuntimeException(e);
			}

			if (result instanceof ModelAndView) {
				ModelAndView mav=ModelAndView.toMAV(result);
				String path=mav.getPath();
				if (StringUtils.isNotEmpty(path)) {
					if (path.startsWith("/")) {
						req.getRequestDispatcher(req.getContextPath() + path).forward(req, resp);
					}else {
						Map<String, Object> model=mav.getModel();
						for (Map.Entry<String, Object> entry : model.entrySet()) {
							req.setAttribute(entry.getKey(), entry.getValue());
						}
						req.getRequestDispatcher(ConfigHelper.getAppJspPath() + path).forward(req, resp);
					}

				} else {
					throw new RuntimeException("path error : " + path);
				}
			} else if (result instanceof JSONData) {
				JSONData data=JSONData.toData(result);
				write2resp(resp,data.getModel());
			} else{
				throw new RuntimeException("error result type:"
						+ (result == null ? null : result.getClass().getTypeName())
						+",need "+ModelAndView.class.getTypeName()
						+" or "+JSONData.class.getTypeName());
			}


		}
	}

	/**
	 * 将数据会写给客户端
	 * @param resp
	 * @param model
	 */
	private void write2resp(HttpServletResponse resp, Object model) {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		PrintWriter writer = null;
		try {
			writer=resp.getWriter();
			writer.write(JsonUtils.toJsonString(model));

		} catch(IOException e) {
			LOGGER.error("response error", e);
			throw new RuntimeException(e);
		}finally {
			if (writer != null) {
				writer.flush();
				writer.close();
			}
		}
	}

	/**
	 * 从request中获取参数
	 *
	 * @param req
	 * @return
	 * @throws IOException
	 */
	private Param getParams(HttpServletRequest req) throws IOException {
		Map<String, Object> params=new HashMap<>();
		Map<String, String[]> parameterMap=req.getParameterMap();

		params.putAll(parameterMap);
		String body=CodecUtils.decodeUrl(StreamUtils.getString(req.getInputStream()));
		if (StringUtils.isNotEmpty(body)) {
			Arrays.stream(StringUtils.split(body, "&")).forEach(param -> {
				String[] pKV=StringUtils.split(param, "=");
				if (pKV == null || pKV.length != 2) {
					throw new IllegalArgumentException("参数不正常:" + param);
				}
				params.put(pKV[0], pKV[1]);
			});

		}
		return new Param(params);
	}
}
