package org.javalusir.design_model.factory;

/**
 * Car factory
 * @author JavaLuSir
 * 
 */
public class CarFactory extends Factory {

	public Car crateObject() {
		return new Car();
	}

	//check the object has been get is car instance or not
	public static void main(String[] args) {
			Factory f = new CarFactory();
			Object obj = f.crateObject();
			System.out.println(obj instanceof Car);
	}
}
