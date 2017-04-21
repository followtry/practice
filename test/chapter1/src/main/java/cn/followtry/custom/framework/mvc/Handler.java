package cn.followtry.custom.framework.mvc;

import java.lang.reflect.Method;

/**
 * Created by followtry on 2017/4/13.
 */
public class Handler {
	private Class<?> controllerClass;

	private Method actionMethod;

	public Handler(Class<?> controllerClass, Method actionMethod) {
		this.controllerClass=controllerClass;
		this.actionMethod=actionMethod;
	}

	public Class<?> getControllerClass() {
		return controllerClass;
	}

	public void setControllerClass(Class<?> controllerClass) {
		this.controllerClass=controllerClass;
	}

	public Method getActionMethod() {
		return actionMethod;
	}

	public void setActionMethod(Method actionMethod) {
		this.actionMethod=actionMethod;
	}
}
