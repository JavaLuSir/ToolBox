package org.javalusir.util;

import java.util.ResourceBundle;
/**
 * this class is use to read properties file
 * @author javalusir
 *
 */
public class BundleReadPropertis {

	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("prop");
		System.out.println(rb.getString("id"));
		System.out.println(rb.getString("name"));
	}
}
