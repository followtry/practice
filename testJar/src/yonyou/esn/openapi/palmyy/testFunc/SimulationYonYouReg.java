/**
 * 
 */
package yonyou.esn.openapi.palmyy.testFunc;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import yonyou.esn.openapi.palmyy.MessageUtil;

import com.alibaba.fastjson.JSON;

/**
 * 
 * 测试掌上用友的登录功能
 * @author jingzz
 * @time 2016年7月7日 上午10:24:51
 * @name palmyy-plugin/com.yonyou.maweb.palmyyplugin.testFunc.TestLoginFunc
 * @since 2016年7月7日 上午10:24:51
 */
public class SimulationYonYouReg {
	
	public static void main(String[] args) throws Exception {
		Map<String, Object> initParams = new HashMap<String,Object>();
		
		//登录
//		String result = login(initParams);
//		System.out.println(result);
		
		//登录后考勤 read(json, "$.store.book[*].author") 
//		String random = JsonPath.read(result, "$.response.random");
		
		
		
		//签到
		reg(initParams, null);
		
		//获取签到地点
//		getOfficeList(initParams, random);
	}

	/**
	 * @author jingzz
	 * @param initParams
	 * @param random
	 * @throws Exception
	 */
	public static void getOfficeList(Map<String, Object> initParams, String random) throws Exception {
		if (random != null && random.length() > 0) {
			System.out.println(random);
		}
		
		Map<String, Object> serverid = new HashMap<String,Object>();
		Map<String, Object> param = new HashMap<String,Object>();
		serverid = new HashMap<String,Object>();
		param = new HashMap<String,Object>();
		serverid.put("method", "GetOffice");
		param.put("uid", "0000059380");
		param.put("port",1 );
		param.put("random", random);
		param.put("apiversion", "6.0.2");
		
		initParams.put("serverid", serverid);
		initParams.put("param", param);
		String reg = JSON.toJSONString(initParams);
		String res = sendPost(reg);
		System.out.println(res);
	}

	/**
	 * @author jingzz
	 * @param initParams
	 * @return
	 * @throws Exception
	 */
	public static String login(Map<String, Object> initParams) throws Exception {
		Map<String, Object> serverid = new HashMap<String,Object>();
		Map<String, Object> param = new HashMap<String,Object>();
		
		serverid.put("method", "UserLogin");
		param.put("usename", "jingzz");
		param.put("password", "jingzz@2015");
		param.put("IMEI", "867570029680224");
		param.put("MODEl", "m2 note");
		param.put("SDK", "Android5.1");
		param.put("telephone", "18500054483");
		param.put("mac", "68:3e:34:3c:38:02");
		param.put("port",1 );
		param.put("apiversion", "6.0.2");
		param.put("launchid", "launch_150914");
		param.put("deviceName", "meizu");
		
		initParams.put("serverid", serverid);
		initParams.put("param", param);
		
		String jsonParam = JSON.toJSONString(initParams);
		
		String result = sendPost(jsonParam);
		return result;
	}

	/**
	 * @author jingzz
	 * @param initParams
	 * @param random
	 * @throws Exception
	 */
	public static String reg(Map<String, Object> initParams, String random) throws Exception {
		Map<String, Object> serverid;
		Map<String, Object> param;
		if (random != null && random.length() > 0) {
			System.out.println(random);
		}
		
		serverid = new HashMap<String,Object>();
		param = new HashMap<String,Object>();
		serverid.put("method", "UpRegister");
		param.put("uid", "0000059380");
		param.put("leaderuid", "0000027432");
		param.put("type", 0);
		param.put("Longitude", "116.230388");
		param.put("Latitude", "40.066738");
		param.put("Longitude", "116.242607");
		param.put("Latitude", "40.072956");
		param.put("officeID", "141126195953af8bdf67");
		param.put("mac", "68:3e:34:3c:38:02");
		param.put("port",1 );
		param.put("apiversion", "6.0.2");
		param.put("random", random);
		
		param.put("address", "");
		
		param.put("actid", "");
		param.put("subject", "");
		param.put("remark", "");
		param.put("regpoto", "");
		param.put("token", "");
		
		initParams.put("serverid", serverid);
		initParams.put("param", param);
		String reg = JSON.toJSONString(initParams);
		String res = sendPost(reg);
		System.out.println(res);
		return res;
	}

	/**
	 * @author jingzz
	 * @param jsonParam
	 * @return
	 * @throws Exception
	 */
	public static String sendPost(String jsonParam) throws Exception {
		System.out.println("params:"+jsonParam);
		byte[] encrypt = MessageUtil.Encrypt(jsonParam);
		
		String url = "http://l.yonyou.com/apitest/MobileService.ashx";
		InputStream gInputStream = RESTRequestSender.sendPost(url , encrypt);
		String string = gInputStream.toString();
		String result = MessageUtil.DesEncrypt(gInputStream);
		return result;
	}
}
