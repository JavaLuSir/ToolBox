package org.javalusir.seri;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * java unserialize demo
 * @author javalusir
 *
 */
public class unSerialDemo{
	
	public static void main(String[] args) {
		File file = new File ("E:\\ent.dat");
		InputStream in;
		try {
			in = new FileInputStream(file);
			ObjectInputStream dis = new ObjectInputStream(in);
			Object o=dis.readObject();
			Field[] fields = o.getClass().getDeclaredFields();
			Method[] method = o.getClass().getMethods();
			for(Method m : method){
				for(Field f:fields){
					if(!m.getName().substring(0,3).equals("set")&&m.getName().toLowerCase().substring(3).equals(f.getName())){
						System.out.println(String.valueOf(m.invoke(o)));
						}
				}
				}
			dis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
