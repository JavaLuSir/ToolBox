package org.javalusir.design_model.mediator;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMediator {

	public List<Colleague> list = new ArrayList<Colleague>();
	
	public abstract void addColleague(Colleague c);
	
	public abstract void removeColleague(Colleague c);
	
	public abstract void clearColleague();
	
	public abstract void action(Colleague c);
	
}
