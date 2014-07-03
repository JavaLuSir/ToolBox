package org.javalusir.design_model.responsibility;

public abstract class Handler {

	protected Handler successor;
	
	protected abstract void dealRequest();

	public Handler getSuccessor() {
		return successor;
	}

	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}
	
}
