package org.javalusir.design_model.builder;

public class SubBuilder extends Builder{

	@Override
	public void buildHead() {
		person.setHead("head");
		System.out.println("build head");
		
	}

	@Override
	public void buildBody() {
		person.setBody("body");
		System.out.println("build body");
		
	}

	@Override
	public void buildFoot() {
		person.setFoot("foot");
		System.out.println("build foot");
		
	}

}
