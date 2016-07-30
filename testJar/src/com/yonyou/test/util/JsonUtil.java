package com.yonyou.test.util;


import java.util.List;

import com.alibaba.fastjson.JSON;

public class JsonUtil {

	
	private JsonUtil() {
	}

	/**
	 * 生成结果json
	 * 
	 * @param results
	 * @return
	 * @throws Exception 
	 */
	public static String generateJson(Object obj)  {
		if (null==obj) 
			return "{}";
		String objJson = JSON.toJSONString(obj);
		return objJson;
	}

	/**
	 * 解析参数json
	 * 
	 * @param <T>
	 * @param json
	 * @return sip帐号list
	 */
	public static <T> Object paseJson(String json, Class<T> c) {
		T obj = JSON.parseObject(json, c);
		return obj;
	}
	
	/**
	 * 解析参数json
	 * 
	 * @param <T>
	 * @param json
	 * @return sip帐号list
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List paseArray(String json, Class c) {
		List obj = JSON.parseArray(json, c);
		return obj;
	}
}
