package com.joseph.util.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Joseph
 */
public class PropertyUtil {
	/**
	 * 数据库资源文件
	 */
	protected static final String JDBC_RESOURCES_PROPERTIES_FILE_NAME = "properties/jdbc.properties";

	/**
	 * 系统资源文件
	 */
	protected static final String SYSTEM_PROPERTIES_FILE_NAME = "properties/system.properties";

	/**
	 * 消息资源文件
	 */
	protected static final String MESSAGE_RESOURCES_PROPERTIES_FILE_NAME = "message/message.properties";

	/**
	 * 微信
	 */
	protected static final String WX_PROPERTIES_FILE_NAME = "properties/wx.properties";

	/**
	 * Redis
	 */
	protected static final String REDIS_RESOURCES_PROPERTIES_FILE_NAME = "properties/redis.properties";

	/**
	 * 获取资源文件的共通方法
	 *
	 * @param propertiesFileName
	 * @return
	 * @throws IOException
	 */
	protected static Properties getProperties(String propertiesFileName) throws IOException {
		Properties prop = new Properties();
		InputStream is = PropertyUtil.class.getClassLoader().getResourceAsStream(propertiesFileName);

		try {
			prop.load(is);
		} catch (IOException e) {
			throw e;
		}

		return prop;
	}

	/**
	 * 系统资源文件
	 *
	 * @return
	 * @throws IOException
	 */
	public static Properties getJDBCProperties() {
		try {
			return getProperties(JDBC_RESOURCES_PROPERTIES_FILE_NAME);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return null;
	}

	/**
	 * 系统资源文件
	 *
	 * @return
	 * @throws IOException
	 */
	public static String getJDBCPropertiesValue(String key) {
		Properties properties = getJDBCProperties();
		return properties == null ? "" : properties.getProperty(key);
	}

	/**
	 * 消息资源文件
	 *
	 * @return
	 * @throws IOException
	 */
	public static Properties getMessageResourcesProperties() {
		try {
			return getProperties(MESSAGE_RESOURCES_PROPERTIES_FILE_NAME);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return null;
	}

	/**
	 * 消息资源文件
	 *
	 * @return
	 * @throws IOException
	 */
	public static Properties getSystemResourcesProperties() {
		try {
			return getProperties(SYSTEM_PROPERTIES_FILE_NAME);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return null;
	}


	/**
	 * 服务资源文件
	 *
	 * @return
	 * @throws IOException
	 */
	public static String getSystemResourcesPropertieValue(String key) {
		Properties properties = getSystemResourcesProperties();
		return properties == null ? "" : properties.getProperty(key);
	}

	/**
	 * 消息资源文件
	 *
	 * @return
	 * @throws IOException
	 */
	public static String getMessageResourcesPropertieValue(String key) {
		Properties properties = getMessageResourcesProperties();
		return properties == null ? "" : properties.getProperty(key);
	}

	/**
	 * Wx
	 *
	 * @return
	 * @throws IOException
	 */
	public static Properties getWxResourcesProperties() {
		try {
			return getProperties(WX_PROPERTIES_FILE_NAME);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return null;
	}

	/**
	 * Wx
	 *
	 * @return
	 * @throws IOException
	 */
	public static String getWxResourcesPropertieValue(String key) {
		Properties properties = getWxResourcesProperties();
		return properties == null ? "" : properties.getProperty(key);
	}


	/**
	 * 取得redis文件
	 *
	 * @return
	 * @throws IOException
	 */
	public static Properties getRedisResourcesProperties() {
		try {
			return getProperties(REDIS_RESOURCES_PROPERTIES_FILE_NAME);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return null;
	}

	/**
	 * 取得redis文件的属性值
	 *
	 * @return
	 * @throws IOException
	 */
	public static String getRedisValue(String key) {
		Properties properties = getRedisResourcesProperties();
		return properties == null ? "" : properties.getProperty(key);
	}
}
