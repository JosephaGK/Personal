package com.joseph.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author Joseph
 */
public class SendEmail {
	/**
	 * 发送邮箱的账号
	 */
	private static String userName="942618763@qq.com";
	/**
	 * 发送邮箱的密码16位STMP口令
	 */
	private static String password="doympitgprthbfbf";
	/**
	 * 昵称,可自定义
	 */
	private static String nickName="CESHI";
	/**
	 * SMTP服务器地址
	 */
	private static String smtp="smtp.qq.com";
	/**
	 * 收件人邮箱的账号
	 */
	private static String receiveUserName="gekun@lianxin-tech.com";
	/**
	 * 收件人邮箱的昵称可自定义
	 */
	private static String receiveNickName="AAAAA";

	public static void main(String[] args) throws Exception {
		//1、构建一个继承自javax.mail.Authenticator的具体类
		//   并重写里面的getPasswordAuthentication()方法
		//   此类是用作登录校验的，以确保你对该邮箱有发送邮件的权利。
		Authenticator auth = new Authenticator() {
			@Override protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(SendEmail.userName,SendEmail.password);
			}
		};
		//2、构建一个properties文件，该文件中存放SMTP服务器地址等参数。
		Properties properties = new Properties();
		// 使用的协议（JavaMail规范要求）
		properties.setProperty("mail.transport.protocol", "smtp");
		// 发件人的邮箱的 SMTP 服务器地址,不同的服务器地址不同
		properties.setProperty("mail.smtp.host", SendEmail.smtp);
		// 需要请求认证
		properties.setProperty("mail.smtp.auth", "true");
		// QQ邮箱端口587
		properties.setProperty("mail.smtp.port", "587");
		//3、通过构建的properties文件和javax.mail.Authenticator具体类来创建一个javax.mail.Session
		//   Session的创建，就相当于登录邮箱。
		Session session = Session.getDefaultInstance(properties, auth);
		// 设置为debug模式, 可以查看详细的发送 log
		session.setDebug(true);
		//4、构建邮件内容，一般是javax.mail.internet.MimeMessage对象
		//   并指定发送人，收信人，主题，内容等等。
		MimeMessage mimeMessage = new MimeMessage(session);
		//发件人,昵称,编码
		mimeMessage.setFrom(new InternetAddress(SendEmail.userName,SendEmail.nickName, "UTF-8"));
		//收件人,昵称,编码
		//MimeMessage.RecipientType为发送方式
		mimeMessage.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(SendEmail.receiveUserName, SendEmail.receiveNickName, "UTF-8"));
		mimeMessage.setSubject("测试主题");
		mimeMessage.setText("测试内容");
		//5、使用javax.mail.Transport工具类发送邮件。
		Transport transport = session.getTransport();
		transport.connect(SendEmail.userName,SendEmail.password);
		transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());
	}
}
