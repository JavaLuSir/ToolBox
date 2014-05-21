package org.javalusir.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@SuppressWarnings("deprecation")
public class SpringDemo {
	
	public static void main(String[] args) {
		
		Resource rs = new ClassPathResource("spring-beans.xml");
		BeanFactory factory = new XmlBeanFactory(rs);
		HelloSpring hello = (HelloSpring) factory.getBean("helloBean");
		hello.hello();
		System.out.println(hello.getHello());
		
	}
}
