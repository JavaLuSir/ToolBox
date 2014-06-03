package org.javalusir.design_model.template;

/**
 * Template method client class
 * @author JavaLuSir
 *
 */
public class Client {

	public static void main(String[] args) {
		Template t1 = new ATemplate();
		t1.templateMethod();
		t1 = new BTemplate();
		t1.templateMethod();
	}
}
