package org.javalusir.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler{

	private Object target;
	
	public MyHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method m, Object[] args)
			throws Throwable {
		System.out.println("This Proxy Class....");
		m.invoke(target, args);
		return null;
	}
	public Object getTarget() {
		return target;
	}
	public void setTarget(Object target) {
		this.target = target;
	}

}
