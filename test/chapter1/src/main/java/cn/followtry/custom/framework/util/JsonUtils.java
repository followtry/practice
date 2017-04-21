package cn.followtry.custom.framework.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by followtry on 2017/4/13.
 */
public class JsonUtils {

	private static final Logger LOGGER=LoggerFactory.getLogger(JsonUtils.class);

	/**
	 * 将对象转为json字符串
	 * @param obj
	 * @param <T>
	 * @return
	 */
	public static <T> String toJsonString(T obj) {
		String res=JSON.toJSONString(obj);
		return res;
	}

	/**
	 * 将json字符串转为指定对象
	 * @param json
	 * @param targetType
	 * @param <T>
	 * @return
	 */
	public static <T> T fromJson(String json, Class<T> targetType) {
		T obj=JSON.parseObject(json, targetType);
		return obj;
	}

	/**
	 * 将自定的字符换转为java可操作的JSONObject
	 * @param json
	 * @return
	 */
	public static JSONObject fromJson(String json) {
		JSONObject obj=JSON.parseObject(json);
		return obj;
	}
}
