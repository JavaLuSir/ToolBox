package org.javalusir.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * use stream copy a file demo
 * @author javalusir
 *
 */
public class BinaryFileReadWrite {

	public static void main(String[] args) {
		File file = new File("d:\\bb.bmp");
		File file2 = new File("d:\\bb2s.bmp");
		
		InputStream fs = null;
		BufferedInputStream bi = null;

		OutputStream fo = null;
		BufferedOutputStream bo = null;
		
		try {
			fs = new FileInputStream(file);
			bi = new BufferedInputStream(fs);
			int len = bi.available();
			System.out.println(len);
			byte[] b = new byte[len];
			while((bi.read(b, 0, len))!=-1){
				bi.read(b);
			}
			fo= new FileOutputStream(file2);
			bo = new BufferedOutputStream(fo);
			
			fo.flush();
			bo.flush();
			bo.write(b,0,len);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				bi.close();
				fs.close();
				bo.close();
				fo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
