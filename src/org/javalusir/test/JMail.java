package org.javalusir.test;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMessage;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.util.MimeMessageParser;

public class JMail {

	public static void main(String[] args) throws Exception {

		Properties prop = new Properties();
		// 开启debug调试  
      //  prop.setProperty("mail.debug", "true"); 
        // 发送服务器需要身份验证  
        prop.setProperty("mail.smtp.auth", "true");  
        // 设置邮件服务器主机名  
        
        prop.setProperty("mail.pop3.host", "pop.tom.com");

        prop.setProperty("mail.imap.host", "imap.tom.com");  
        
        prop.setProperty("mail.store.protocol", "imap");
        // 发送邮件协议名称  
        //prop.setProperty("mail.transport.protocol", "smtp"); 
        
        String protocol="imap";
        Authenticator auth = new DefaultAuthenticator("qqaaa_1@tom.com","123456");
        
        Session session = Session.getInstance(prop, auth);
        
        Store store = session.getStore(protocol);
       
        session.setDebug(true);
        Folder folder = null;

        //store = protocol == null || protocol.trim().length() == 0 ? session.getStore() : session.getStore(protocol);
        
                    store.connect();
                    folder = store.getFolder("INBOX");// 获取收件箱
                    folder.open(Folder.READ_ONLY); // 以只读方式打开
                    Message[] messages = folder.getMessages();
                    System.out.println(messages.length);
                    for(Message message:messages){
                    	MimeMessageParser mp = new MimeMessageParser((MimeMessage)message).parse();
                    	String userFrom = mp.getFrom();
                    	String title = mp.getSubject();
                    	//String text = mp.getPlainContent();
                    	//String htmlContent = mp.getHtmlContent();
                    	System.out.println("来自:"+userFrom);
                    	System.out.println("主题:"+title);
                    	//System.out.println("内容:"+text);
                    	//System.out.println("内容:"+htmlContent);
                    }
                    folder.close(false);

	}
}
