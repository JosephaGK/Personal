package com.joseph.international;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Joseph
 */
public class InternationalTest {
	public static void main(String[] arg){
		Locale loc = new Locale("zh","CN");
		ResourceBundle bundle = ResourceBundle.getBundle("international.Message_zh_CN",loc);
		String test = bundle.getString("test");
		System.out.println(test);
	}
}
