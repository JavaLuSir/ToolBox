package org.javalusir.datastructure_aglorithm;
/**
 * This class is a demo for devideFinding
 * @author javalusir
 *
 */
public class DevideFinding {
	
	private int[] dfarry;
	private int length;

	/**
	 * constructor 
	 */
	public DevideFinding() {
		length=0;
	}
	
	/**
	 * constructor 
	 * @param size array size
	 * @param param int value
	 */
	public DevideFinding(int size,int[] param) {
		
		dfarry = new int[size];
		this.length=size;
		for(int i=0;i<size;i++){
			dfarry[i] = param[i];
		}
		
	}
	
	/**
	 *  bubble sort the arry from min to max
	 */
	public void bubbleSort(){
		for(int i=dfarry.length-1;i>0;i--){
			for(int j=0;j<i;j++){
				if(dfarry[j]>dfarry[j+1]){
					int tmp;
					tmp=dfarry[j];
					dfarry[j]=dfarry[j+1];
					dfarry[j+1]=tmp;
				}
			}
		}
	}
	
	
	/**
	 * insert value
	 */
	public void insert(){
		bubbleSort();
		
	}
	
	/**
	 * find the value have been given if exist return true
	 * else return false
	 * @param param value
	 * @return boolean
	 */
	public boolean find(int param) {
		int lowerBounds = 0;
		int higherBounds = length - 1;
		
		while (true) {
			
			int current = (lowerBounds + higherBounds) / 2;
			
			if (dfarry[current] == param){
				System.out.println("index:"+current);
				return true;
				}
			else if (lowerBounds > higherBounds)
				return false;
			else {
				if (dfarry[current] > param)
					higherBounds = current - 1;
				else if (dfarry[current] < param)
					lowerBounds = current + 1;
			}
		}
	}
	
	/**
	 * get array real size
	 */
	public int trimToSize(){
		bubbleSort();
		for(int i=0;i<dfarry.length;i++){
			if(dfarry[i]==0)
				return i+=1;
		};
		return length;
	}
	
	
	/**
	 * show array all value
	 */
	public void display(){
		for(int o:dfarry)
			System.out.println(o);
	}
	 
	/**
	 * main test
	 * @param args
	 */
	public static void main(String[] args) {
		//Integer[] a = new Integer[]{5,34,123,76,98,4};
		int[] a = new int[]{5,34,123,76,98,4};
		Sort.insertSort(a);
		DevideFinding df = new DevideFinding(a.length,a);
		System.out.println("!!"+df.trimToSize());
		
		//df.bubbleSort();
		System.out.println(df.find(76));
		df.display();
	}
}
