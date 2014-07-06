package org.javalusir.design_model.mediator;

public class User extends Colleague{

	public User(AbstractMediator mediator) {
		super(mediator);
	}

	@Override
	public void receivedMessage(String msg) {
		System.out.println("user has got the message -'" + msg + "'");
	}

	@Override
	public void sendMessage() {
		System.out.println("user has send the message -'" + this.getMessage() + "'");
	}
	
	

}
