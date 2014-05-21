package org.javalusir.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
/**
 * UDPSocketDemo Server
 * @author javalusir
 *
 */
public class UDPSocketServer {

	public static void main(String[] args) {
		try {
			System.out.println("server...");
			DatagramSocket ds = new DatagramSocket(9876);
			byte[] rdata = new byte[1024];
			while(true){
				DatagramPacket dp = new DatagramPacket(rdata,rdata.length);
				ds.receive(dp);
				//1.5以前获取实际字节长度到新byte数组
				byte[] receivedData = new byte[dp.getLength()];
				System.arraycopy(dp.getData(), dp.getOffset(), receivedData, 0, receivedData.length);
				//1.5以上
				//byte[] d=Arrays.copyOfRange(dp.getData(), dp.getOffset(), dp.getOffset()+dp.getLength());
				String ss = new String(receivedData);
				System.out.println("ReceivedPath:"+dp.getAddress());
				System.out.println("ReceivedPort:"+dp.getPort());
				System.out.println("Received:"+ss);
				dp.setLength(dp.getData().length);
				ds.send(dp);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
