package org.javalusir.datastructure_aglorithm;
/**
 * this class offer Sort Demo
 * @author JavaLuSir
 *
 */
public class Sort {
	
	/**
	 *  bubble sort the arry from min to max
	 */
	public static void bubbleSort(int[] dfarry){
		for(int i=dfarry.length-1;i>0;i--){
			for(int j=0;j<i;j++){
				if(dfarry[j]>dfarry[j+1])
					swap(dfarry,j,j+1);
			}
		}
	}
	/**
	 * selection sort arry from min to max
	 * @param dfarry
	 */
	public static void selectionSort(int[] dfarry){
		for(int i=0;i<dfarry.length-1;i++){
			for(int j=i+1;j<dfarry.length;j++){
				   if(dfarry[i]>dfarry[j])
					   swap(dfarry,i,j);
			}
		}
	}
	
	/**
	 *  insert sort arry from min to max
	 * @param dfarry
	 */
	/*public static void insertSort(int[] dfarry){
		for(int i=1;i<dfarry.length;i++){
			int temp = dfarry[i];
			while(i>0&&dfarry[i-1]>temp){
				dfarry[i]=dfarry[i-1];
				--i;
			}
			dfarry[i]=temp;
		}
		
	}*/
	public static void insertSort(int[] dfarry){
		for(int i=1;i<dfarry.length;i++){
			int temp=dfarry[i];
			while(i>0&&dfarry[i-1]>temp){
				dfarry[i]=dfarry[i-1];
				--i;
			}
			dfarry[i]=temp;
		}
	}
	/**
	 * exchange element in arry by index
	 * @param arry
	 * @param a arry index1
	 * @param b arry index2
	 */
	private static void swap(int[] arry,int a,int b){
		int tmp;
		tmp=arry[a];
		arry[a]=arry[b];
		arry[b]=tmp;
	
	}

}
