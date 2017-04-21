package cn.followtry.custom.framework.core;

import cn.followtry.custom.framework.annotation.Action;
import cn.followtry.custom.framework.mvc.Handler;
import cn.followtry.custom.framework.mvc.Request;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by followtry on 2017/4/13.
 */
public class ControllerHelper {

	@SuppressWarnings("unchecked")
	private static final Map<Request,Handler>  ACTION_MAP = new ConcurrentHashMap(){
		{
			ClassHelper.getControllerClassSet().stream().forEach(aClass -> {
				Method[] methods=aClass.getDeclaredMethods();
				if (ArrayUtils.isNotEmpty(methods)) {
					Arrays.stream(methods).filter(method -> method.isAnnotationPresent(Action.class)).forEach(method -> {
						Action action=method.getAnnotation(Action.class);
						String[] mappings=action.value();
						if (ArrayUtils.isNotEmpty(mappings)) {
							Arrays.stream(mappings).forEach(mapping -> {
								if (mapping.matches("\\w+:/\\w*")) {
									String[] arr=mapping.split(":");
									if (ArrayUtils.isNotEmpty(arr) && arr.length == 2) {
										String reqMethod=arr[0];
										String reqPath=arr[1];
										Request request=new Request(reqMethod, reqPath);
										Handler handler=new Handler(aClass, method);
										put(request, handler);
									}
								}
							});
						}
					});
				}
			});
		}
	};

	public static Handler getHandler(String reqMethod, String reqPath) {
		return ACTION_MAP.get(new Request(reqMethod, reqPath));
	}
}
