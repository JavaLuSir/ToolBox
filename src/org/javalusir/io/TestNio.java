package org.javalusir.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
/**
 * NIO COPY file demo
 * @author javalusir
 *
 */
public class TestNio {

	public static void main(String[] args) {
		long a=System.currentTimeMillis();
		File file = new File("D:/DEEPIN_GHOST_XPSP3_2013.09.iso");
		File file2 = new File("D:/DEEPIN_GHOST_XPSP3_2013.092.iso");
		
		FileInputStream fis = null;
		FileChannel fcin = null;
		
		FileOutputStream fos = null;
		FileChannel fcout = null;
		try {
			 
			fis =  new FileInputStream(file);
			 fcin=fis.getChannel();
			 
			 fos =  new FileOutputStream(file2);
			 fcout=fos.getChannel();
			 
			ByteBuffer bb = ByteBuffer.allocate(1024);
			
			while(true){
				bb.clear();
				int l=fcin.read(bb);
				if(l==-1)
					break;
				bb.flip();
				fcout.write(bb);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fcin.close();
				fcout.close();
				fis.close();
				fos.close();
				System.out.println(System.currentTimeMillis()-a+"ms");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
