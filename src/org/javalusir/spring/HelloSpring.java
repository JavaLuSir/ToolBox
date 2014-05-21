package org.javalusir.spring;

public class HelloSpring {

	private String hello;
	private IBusiness buss;
	
	public String getHello() {
		return hello;
	}

	public void setHello(String hello) {
		this.hello = hello;
	}

	public void hello() {
		System.out.println("!################");
		
	}

	public IBusiness getBuss() {
		return buss;
	}

	public void setBuss(IBusiness buss) {
		this.buss = buss;
	}

}
