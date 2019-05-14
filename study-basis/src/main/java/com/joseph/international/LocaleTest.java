package com.joseph.international;

import java.util.Locale;

/**
 * @author Joseph
 */
public class LocaleTest {
	public static void main(String[] arg){
		Locale locale = Locale.getDefault();
		System.out.println(locale.getCountry());
	}

}
