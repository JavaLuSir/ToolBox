package org.javalusir.design_model.builder;

public abstract class Builder {

	protected Person person = new Person();
	public abstract void buildHead();
	public abstract void buildBody();
	public abstract void buildFoot();
	
	public Person getResult(){
		return person;
	}

	
}
