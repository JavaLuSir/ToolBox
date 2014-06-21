package org.javalusir.design_model.strategy;

/**
 *  a client class is use to execute Strategy model
 * @author JavaLuSir
 *
 */
public class Client {

	public static void main(String[] args) {
		IStrategy strategy1 = new BikeStrategy();
		IStrategy strategy2 = new TrainStrategy();
		Context ctx = new Context(strategy1);
		ctx.executeStrategy();
		ctx = new Context(strategy2);
		ctx.executeStrategy();
	}
}
