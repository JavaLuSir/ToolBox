package org.javalusir.seri;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * java serialize demo
 * @author javalusir
 *
 */
public class SerialDemo {

	public static void main(String[] args) {
		File file = new File ("E:\\ent.dat");
		OutputStream out;
		try {
			out = new FileOutputStream(file);
			ObjectOutputStream dos = new ObjectOutputStream(out);
			dos.writeObject(new Entity("学号0001","王丽"));
			dos.flush();
			dos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
