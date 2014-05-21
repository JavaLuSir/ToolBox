package org.javalusir.test;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.mail.DefaultAuthenticator;

public class SendEmail {
	
	public static void main(String[] args) throws MessagingException {
		Authenticator auth = new DefaultAuthenticator("javalusir@163.com","lx6416214");
		Properties prop = new Properties();
		// 开启debug调试  
        prop.setProperty("mail.debug", "true"); 
        // 发送服务器需要身份验证  
        prop.setProperty("mail.smtp.auth", "true");  
        // 设置邮件服务器主机名  
        prop.setProperty("mail.host", "smtp.163.com");  
        // 发送邮件协议名称  
        prop.setProperty("mail.transport.protocol", "smtp"); 
        Session session = Session.getInstance(prop,auth);
        Message msg = new MimeMessage(session);
        msg.setSubject("亲爱的~~This is a JavaMail Test!");
        msg.setText("亲爱的这是我发的邮件");
        msg.setFrom(new InternetAddress("javalusir@163.com"));
        Transport transport = session.getTransport();
        transport.connect("javalusir@163.com","lx6416214");
        transport.sendMessage(msg, new Address[]{new InternetAddress("641149960@qq.com")});
        transport.close();
	}

}
