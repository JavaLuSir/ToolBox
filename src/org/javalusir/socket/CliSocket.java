package org.javalusir.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * socket demo client 
 * @author javalusir
 *
 */
public class CliSocket {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1",5678);
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(out, true);
		pw.println("ceshi");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		System.out.println(br.readLine());
		
	}

}
