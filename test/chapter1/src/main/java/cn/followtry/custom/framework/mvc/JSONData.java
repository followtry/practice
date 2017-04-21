package cn.followtry.custom.framework.mvc;

/**
 * JSON数据结构
 * Created by followtry on 2017/4/13.
 */
public class JSONData {
	private Object model;

	public JSONData(Object model) {
		this.model=model;
	}

	public Object getModel() {
		return model;
	}

	public static JSONData toData(Object source) {
		if (source == null) {
			return new JSONData(new Object());
		}

		return (JSONData)source;
	}
}
