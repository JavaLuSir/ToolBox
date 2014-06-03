package org.javalusir.design_model.producer_consumer;

public class Producter implements Runnable{

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ProductStorage.getInstance().puduct();
		}
	}

}
