package org.javalusir.design_model.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

	private List<IObserver> oblist = new ArrayList<IObserver>();
	
	public void attach(IObserver observer){
		oblist.add(observer);
		System.out.println("observer added");
	}
	
	public void detach(IObserver observer){
		oblist.remove(observer);
		System.out.println("observer deleted");
	}
	
	public void notifyAllObserver(String newState){
		for(IObserver ob : oblist){
			ob.update(newState);
		}
	}
}
