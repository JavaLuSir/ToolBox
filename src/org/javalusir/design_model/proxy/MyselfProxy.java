package org.javalusir.design_model.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyselfProxy implements InvocationHandler{

	public Object target;
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		method.invoke(target, args);
		return null;
	}
	
	
	public Object getTarget() {
		return target;
	}
	public void setTarget(Object target) {
		this.target = target;
	}

}
