package org.javalusir.design_model.observer;

/**
 * extends Subject do logic someThing
 * @author JavaLuSir
 *
 */
public class MySubject extends Subject{

	private String observerState;
	
	public void change(String newState){
		observerState = newState;
		System.out.println("主题状态为："+observerState);
		super.notifyAllObserver(newState);
	}
}
