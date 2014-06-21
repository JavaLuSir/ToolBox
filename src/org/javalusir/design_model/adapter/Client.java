package org.javalusir.design_model.adapter;

public class Client {

	public static void main(String[] args) {
		Dollar d = new Dollar(100);
		Dollar_RMB_Adapter dra = new Dollar_RMB_Adapter(d);
		dra.spend();
	}
}
