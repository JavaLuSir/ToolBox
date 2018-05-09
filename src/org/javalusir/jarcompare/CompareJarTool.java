package org.javalusir.jarcompare;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * compare files which is not same in two jars.
 * @author Administrator
 *
 */
public class CompareJarTool {

	public static String getFilesInJar(String jarpath) throws Exception{
		URL[] jarurl = new URL[1];
		
		jarurl[0]=new URL("file","localhost","E:/jdom-1.0.jar");
		URLClassLoader loader = new URLClassLoader(jarurl);
		Class<?> clazz = loader.loadClass("org.jdom.Attribute");
		System.out.println(clazz.getName());
		return jarpath;
		
	}
	
	public static File readDirFiles(File file){
		if(!file.isDirectory()){
			System.out.println(file.getAbsolutePath()+"/"+file.getName());
			return file;
		}else{
			return readDirFiles(file);
		}
	}
	
	public static void main(String[] args) throws Exception {
		CompareJarTool.getFilesInJar("E:/jdom-1.0.jar");
	}
	
	
}
