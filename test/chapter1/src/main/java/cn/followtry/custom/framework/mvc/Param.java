package cn.followtry.custom.framework.mvc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * Created by followtry on 2017/4/13.
 */
public class Param {
	private Map<String, Object> paramMap;

	public Param(Map<String, Object> paramMap) {
		this.paramMap=paramMap;
	}

	public Map<String, Object> getParamMap() {
		return paramMap;
	}

	public Long getLong(String paramName) {
		return Long.valueOf(String.valueOf(paramMap.get(paramName)));
	}
	public Integer getInt(String paramName) {
		return Integer.valueOf(String.valueOf(paramMap.get(paramName)));
	}
	public String getString(String paramName) {
		return String.valueOf(paramMap.get(paramName));
	}
	public JSONObject getJSON(String paramName) {
		return JSON.parseObject(JSON.toJSONString(paramMap.get(paramName)));
	}

	public <T> T getLong(String paramName,Class<T> targetType) {
		return JSON.parseObject(JSON.toJSONString(paramMap.get(paramName)), targetType);
	}
}
