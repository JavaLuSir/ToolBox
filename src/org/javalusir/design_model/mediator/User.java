package org.javalusir.design_model.mediator;

public class User extends Colleague{

	public User(AbstractMediator mediator) {
		super(mediator);
	}

	@Override
	public void sendMessage(String message) {
		this.message=message;
		mediator.action(this);
	}

	@Override
	public void receivedMessage(String msg) {
		System.out.println("Colleague1 has got the message -'" + msg + "'");
	}
	
	

}
