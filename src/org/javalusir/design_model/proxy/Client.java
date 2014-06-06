package org.javalusir.design_model.proxy;

import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args) {
		IProxy p = new ProxyImpl();
		MyselfProxy mf = new MyselfProxy();
		Proxy.newProxyInstance(p.getClass().getClassLoader(), p.getClass().getInterfaces(), mf);
		p.test();
	}
}
