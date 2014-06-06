package org.javalusir.design_model.builder;
/**
 * 
 * @author JavaLuSir
 *
 */
public class Director {

	private Builder build;

	public Director(Builder build) {
		this.build = build;
	}

	public Builder getBuild() {
		return build;
	}

	public void setBuild(Builder build) {
		this.build = build;
	}
	
	public Person construct(){
		build.buildHead();
		build.buildBody();
		build.buildFoot();
		return build.getResult();
	}
	
	
}
