package org.javalusir.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
/**
 * UDBSocket client
 * @author javalusir
 *
 */
public class UDPSocketClient {
	public static void main(String[] args) {
		try {
			String s ="你好 我们测试哟";
			byte[] sdata=s.getBytes();
			
			InetAddress addr = InetAddress.getByName("127.0.0.1");
			DatagramSocket ds = new DatagramSocket();
			DatagramPacket dp = new DatagramPacket(sdata,sdata.length,addr,9876);
			ds.setSoTimeout(10);
			ds.send(dp);
			
			ds.receive(dp);
			String ss = new String(dp.getData());
			System.out.println("receive:"+ss);
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
