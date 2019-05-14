package com.joseph.heapdump;

import java.util.ArrayList;

public class ParameterTest {
	/**
	 * 添加运行jvm参数
	 * -Xmx7m  -XX:+HeapDumpOnOutOfMemoryError
	 * 	//-Xmx7m设置最大堆内存，缩短出现内存溢出时间
	 * 	//-XX:+HeapDumpOnOutOfMemoryError设置出现内存溢出时导出堆文件,后缀名为hprof
	 * @param arg
	 */
	public static void main(String[] arg){
		ArrayList<String> list = new ArrayList<>();
		while (true){
			list.add(new String("test "));
		}
	}
}
