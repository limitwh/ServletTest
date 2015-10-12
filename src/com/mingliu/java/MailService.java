package com.mingliu.java;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {
	public void MailNewUser(String mailadd,String VerifyCode){
		StringBuffer SB= new StringBuffer();
		final String  d_email = "limitem@126.com";
		final String  d_password = "zaq12wsxcde3";
		String	d_host = "smtp.126.com";
		String	d_port = "25";
		String	m_subject = "=== VerifyCode for New User Register ===";
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss ===");
		
		Date date = new Date();
		SB.append(m_subject);
		SB.append(dateFormat.format(date));
		class SMTPAuthenticator extends javax.mail.Authenticator
		{
			public PasswordAuthentication getPasswordAuthentication()
			{
					return new PasswordAuthentication(d_email, d_password);
			}
		}

		Properties props = new Properties();
		props.put("mail.smtp.user", d_email);
		props.put("mail.smtp.host", d_host);
		props.put("mail.smtp.port", d_port);
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", d_port);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");

		try
		{
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getInstance(props, auth);

			MimeMessage msg = new MimeMessage(session);
			msg.setText("Your Register Code is : "+VerifyCode);
			msg.setSubject(SB.toString());
			msg.setFrom(new InternetAddress(d_email));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(mailadd));
			Transport.send(msg);
		}
		catch (Exception mex)
		{
			mex.printStackTrace();
		}
	}
	
	
	
}
