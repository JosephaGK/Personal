package com.joseph.system;

import java.util.Properties;

/**
 * @author Joseph
 */
public class SystemProperties {
	public static void main(String[] arg) {
		//获取所有的属性
		Properties properties = System.getProperties();
		//遍历所有的属性
		for (String key : properties.stringPropertyNames()) {
			//输出对应的键和值
			System.out.println(key + "=" + properties.getProperty(key));
		}
	}
}
