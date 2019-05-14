package com.joseph.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Joseph
 */
public class Logback {


	/**
	 * 	logback是由log4j创始人设计的又一个开源日志组件
	 * 	logback当前分成三个模块：logback-core,logback-classic和logback-access
	 * 	logback-core是其它两个模块的基础模块
	 * 	logback-classic是log4j的一个改良版本
	 * 	logback-classic完整实现SLF4J API使你可以很方便地更换成其它日志系统如log4j或JDK14 Logging
	 * 	logback-access访问模块与Servlet容器集成提供通过Http来访问日志的功能(用的少)
	 * 	logback-classic和logback-access已经依赖logback-core,不需要单独引用
	 */
	private static final Logger logger = LoggerFactory.getLogger(Logback.class);

	public static void main(String[] arg){
		logger.info("zhongwen");
	}

}
