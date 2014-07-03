package org.javalusir.design_model.responsibility;

public class Client {

	public static void main(String[] args) {
		Handler handler1 = new HandlerImpl();
		Handler handler2 = new HandlerImpl();
		Handler handler3 = new HandlerImpl();
		handler1.setSuccessor(handler2);
		handler2.setSuccessor(handler3);
		handler1.dealRequest();
	}
}
