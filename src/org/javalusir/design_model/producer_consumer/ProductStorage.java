package org.javalusir.design_model.producer_consumer;

/**
 * this producter and consumer design model
 * @author JavaLuSir
 *
 */
public class ProductStorage {
	
	public static final int MAXNUM=80;
	
	public static int CURRENNUM=30;
	
	public static ProductStorage instance = null;
	
	private ProductStorage(){}
	
	public static ProductStorage getInstance(){
		if(instance==null)
			return  new ProductStorage();
		return instance;
	}
	/**
	 * puduct a thing
	 */
	public synchronized void puduct(){
		if(CURRENNUM>=MAXNUM/2){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		CURRENNUM++;
		System.out.println("当前线程："+Thread.currentThread().getName() + "--生产者生产了一个商品，当前库存量："+ CURRENNUM);
        notifyAll();
	}
	/**
	 * consum a thing
	 */
	public synchronized void consumer(){
		if(CURRENNUM<0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		CURRENNUM--;
		System.out.println("当前线程："+Thread.currentThread().getName() + "--消费者消费了一个商品，当前库存量："+ CURRENNUM);
        notifyAll();
	}

	
}
