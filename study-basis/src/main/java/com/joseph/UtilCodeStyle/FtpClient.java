package com.joseph.UtilCodeStyle;

/**
 * @author Joseph
 */
public final class FtpClient {

	//定义一些可直接使用的client
	public static final FtpClient HOME_FTPCLIENT = createConstant("127.0.0.1","11");

	public static final FtpClient REMOTE_FTPCLIENT = createConstant("xxxx.x.x.x","");

	private FtpClient() {

	}

	private static FtpClient createConstant(String url,String port) {
		return getInstance();
	}

	static FtpClient getInstance(){
		return new FtpClient();
	}



}
