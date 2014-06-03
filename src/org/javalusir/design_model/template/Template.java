package org.javalusir.design_model.template;

/**
 * template method design model
 * template class offer a final method templateMethod()
 * and invoke init() and end(),doSomething method is for
 * child class to implement 
 * @author JavaLuSir
 *
 */
public abstract class Template {

	/**
	 * this method control whole Process
	 * and doSomething method is abstract
	 * its implemented by child class
	 */
	public final void templateMethod(){
		init();
		doSomething();
		end();
	}
	/**
	 * init method
	 */
	protected void init() {
		System.out.println("This is Template inited");
	}
	/**
	 * implemented by child class
	 */
	protected abstract void doSomething(); 
	/**
	 * end method
	 */
	protected void end() {
		System.out.println("This is endl method");
	} 
	
}
