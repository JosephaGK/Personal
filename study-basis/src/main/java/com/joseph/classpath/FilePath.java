package com.joseph.classpath;

/**
 * @author Joseph
 */
public class FilePath {
	public static void main(String[] arg){
		System.out.println(FilePath.class.getResource(""));
		System.out.println(FilePath.class.getResource("/"));
	}
}
