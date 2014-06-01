package org.javalusir.design_model.observer;

public class MySubject extends Subject{

	private String observerState;
	
	public void change(String newState){
		observerState = newState;
		System.out.println("主题状态为："+observerState);
		this.notifyAllObserver(newState);
	}
}
