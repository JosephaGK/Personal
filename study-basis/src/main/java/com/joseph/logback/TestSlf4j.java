package com.joseph.logback;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestSlf4j {
	public static void main(String[] arg){
		//@Slf4j可以不写private  final Logger logger = LoggerFactory.getLogger(XXX.class);
		//直接使用log
	    log.info("testSlf4j");
	}
}
