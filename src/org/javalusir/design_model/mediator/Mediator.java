package org.javalusir.design_model.mediator;

public class Mediator extends AbstractMediator{

	@Override
	public void addColleague(Colleague c) {
		list.add(c);
	}

	@Override
	public void removeColleague(Colleague c) {
		list.remove(c);
	}

	@Override
	public void clearColleague() {
		list.clear();
	}

	@Override
	public void action(Colleague c) {

		   String msg = c.getMessage();
		   // send msg
		   for (Colleague colleague : list) {
		    if (colleague.equals(c)) {
		     colleague.sendMessage(msg);
		     break;
		    }
		   }
		   // got msg
		   for (Colleague colleague : list) {
		    if (colleague.equals(c))
		     continue;
		    else
		    colleague.receivedMessage(msg);
		   }
	}

	
}
