package org.javalusir.strategy;
/**
 * a class use Strategy model
 * @author JavaLuSir
 *
 */
public class Context {

	private IStrategy strategy;
	
	public Context(IStrategy strategy){
		this.strategy=strategy;
	}
	
	public void executeStrategy(){
		strategy.goSomeWhere();
	}
}
