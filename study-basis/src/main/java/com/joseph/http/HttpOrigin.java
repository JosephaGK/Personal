package com.joseph.http;

import java.net.URL;
import java.net.URLConnection;

/**
 * @author Joseph
 */
public class HttpOrigin {
	public static void main(String[] arg) throws Exception {
		String url = "http://127.0.0.1:8080/ssm-admin";
		URLConnection connection =getConnection(url);


	}


	private static URLConnection getConnection(String url) throws Exception {
		URL realUrl = new URL(url);
		URLConnection connection = realUrl.openConnection();
		connection.setRequestProperty("accept","/");
		connection.connect();
		return connection;
	}
}
