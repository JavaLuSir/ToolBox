package org.javalusir.design_model.mediator;

public class Worker extends Colleague{

	public Worker(AbstractMediator mediator) {
		super(mediator);
	}

	@Override
	public void sendMessage(String message) {
		this.message=message;
		mediator.action(this);
	}

	@Override
	public void receivedMessage(String msg) {
		System.out.println("woker has got the message -'" + msg + "'");
	}
	
	

}
