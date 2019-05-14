package com.joseph.servlet3;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @author Joseph
 */
@WebListener
public class ListenerAnnotation implements ServletRequestListener {
	@Override public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("=======webListener======");
	}

	@Override public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("=======webListener======");
	}
}
