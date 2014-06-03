package org.javalusir.design_model.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * this abstract class provided a Subject
 * add  IObserver to a collection by notifyAllObserver
 * to invoke other to update
 * @author JavaLuSir
 *
 */
public abstract class Subject {

	private List<IObserver> oblist = new ArrayList<IObserver>();
	/**
	 * add observer
	 * @param observer
	 */
	public void attach(IObserver observer){
		oblist.add(observer);
		System.out.println("observer added");
	}
	/**
	 * remove a observer
	 * @param observer
	 */
	public void detach(IObserver observer){
		oblist.remove(observer);
		System.out.println("observer deleted");
	}
	/**
	 * invoke other class update message
	 * @param newState message of update
	 */
	public void notifyAllObserver(String newState){
		for(IObserver ob : oblist){
			ob.update(newState);
		}
	}
}
