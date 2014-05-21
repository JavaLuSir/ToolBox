package org.javalusir.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * read the file which in a dir 
 * @author javalusir
 *
 */
public class TextReadFile {
	//System.out.println(System.getProperty("user.dir"));

	private static String dir = "E:\\abc";
	public static void main(String[] args) throws IOException {
		
		TextReadFile r=new TextReadFile();
		
		List<String> s=r.searchFile(dir,new ArrayList<String>());
		for(String str:s){
				File file = new File(str);
					FileReader fr = new FileReader(file);
					BufferedReader bf = new BufferedReader(fr);
					while(bf.ready()){
						System.out.println(bf.readLine());
					}
					bf.close();
			}
				
	}
	/**
	 * search file include 
	 * @param filepath
	 * @param list use to collect file path don't include dir
	 * @return
	 */
	public List<String> searchFile(String filepath,List<String> list){
		File file = new File(filepath);
		String[] sqls = null;
		
		if(file.isDirectory()){
			sqls=file.list();
			for(String s:sqls){
				searchFile(filepath+File.separator+s,list);
			}
			return list;
			}else{
				list.add(filepath);
				return list;
			}
		
	}
}
