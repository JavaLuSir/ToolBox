package org.javalusir.strategy;

/**
 *  a client class is use to execute Strategy model
 * @author JavaLuSir
 *
 */
public class Client {

	public static void main(String[] args) {
		IStrategy strategy1 = new BikeStrategy();
		IStrategy strategy2 = new TrainStrategy();
		Context ctx1 = new Context(strategy1);
		Context ctx2 = new Context(strategy2);
		ctx1.executeStrategy();
		ctx2.executeStrategy();
	}
}
