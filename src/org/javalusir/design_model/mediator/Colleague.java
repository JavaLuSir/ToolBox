package org.javalusir.design_model.mediator;

public abstract class Colleague {
	
	public Colleague(AbstractMediator mediator){
		
	}
	protected AbstractMediator mediator;

	protected String message;
	
	public abstract void sendMessage(String message);
	
	public abstract void receivedMessage(String msg);
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AbstractMediator getMediator() {
		return mediator;
	}

	public void setMediator(AbstractMediator mediator) {
		this.mediator = mediator;
	}
}
