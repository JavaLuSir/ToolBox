package org.javalusir.test;

import java.io.Serializable;


import org.javalusir.singleon.Singleon;

public class SS implements Runnable,Serializable{
	private Object a = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		
		
	}



	@Override
	public void run() {
		a = Singleon.getinstance();
		System.out.println(a);
	}

	public Object getA() {
		return a;
	}

	public void setA(Object a) {
		this.a = a;
	}
}
