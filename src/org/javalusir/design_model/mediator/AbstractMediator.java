package org.javalusir.design_model.mediator;

public abstract class AbstractMediator {

	public abstract void addColleague(Colleague c);
	
	public abstract void removeColleague(Colleague c);
	
	public abstract void clearColleague();
	
	public abstract void action(Colleague c);
	
}
