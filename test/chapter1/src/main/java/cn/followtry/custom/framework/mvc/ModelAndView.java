package cn.followtry.custom.framework.mvc;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 视图
 * Created by followtry on 2017/4/13.
 */
public class ModelAndView {

	private String path;

	private Map<String, Object> model;

	public ModelAndView(String path) {
		this.path=path;
		model=new HashMap<>();
	}

	public ModelAndView addModel(String key, String value) {
		model.put(key, value);
		return this;
	}

	public ModelAndView addAllModel(Map<String, ? extends Object> models){
		model.putAll(models);
		return this;
	}

	public String getPath() {
		return path;
	}

	public Map<String, Object> getModel() {
		return model;
	}

	public static ModelAndView toMAV(Object source) {
		Objects.requireNonNull(source, "view path can not be empty");
		return  (ModelAndView)source;
	}
}
