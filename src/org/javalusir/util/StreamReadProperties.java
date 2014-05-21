package org.javalusir.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class StreamReadProperties {

	public static void main(String[] args) throws IOException {
		InputStream in = StreamReadProperties.class.getClassLoader().getResourceAsStream("prop.properties");
		Properties p = new Properties();
		p.load(in);
		System.out.println(p.getProperty("id"));
		System.out.println(p.getProperty("name"));
				
	}
}
