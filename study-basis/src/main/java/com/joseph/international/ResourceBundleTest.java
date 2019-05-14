package com.joseph.international;

import java.util.Enumeration;
import java.util.ResourceBundle;

/**
 * @author Joseph
 */
public class ResourceBundleTest {
	public static void main(String[] arg){
		ResourceBundle bundle = ResourceBundle.getBundle("international.Message_zh_CN");
		Enumeration<String> keys = bundle.getKeys();
		while (keys.hasMoreElements()) {
			System.out.println(keys.nextElement());
		}
	}
}
