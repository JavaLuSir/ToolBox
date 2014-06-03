package org.javalusir.design_model.producer_consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * test Class
 * @author JavaLuSir
 *
 */
public class Client {

	public static void main(String[] args) {
		startProducet();
		startConsumer();
	}
	/**
	 * use Producter 
	 */
	public static void startProducet(){
		System.out.println("--生产者线程执行开始--");
		int pSize = 10;
		ExecutorService pool = Executors.newFixedThreadPool(pSize);
		for(int i=0;i<pSize;i++){
			Producter p = new Producter();
			Thread t = new Thread(p);
			pool.execute(t);
		}
		System.out.println("--生产者线程执行结束--");
	}
	/**
	 * use Consumer
	 */
	public static void startConsumer(){
		  System.out.println("--消费者线程执行开始--");
		int cSize = 10;
		ExecutorService pool = Executors.newFixedThreadPool(cSize);
		for(int i=0;i<cSize;i++){
			Consumer c = new Consumer();
			Thread t = new Thread(c);
			pool.execute(t);
		}
		  System.out.println("--消费者线程执行结束--");
	}
}
