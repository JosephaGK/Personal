package com.joseph.trycatch;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author Joseph
 */
public class TryWithResource {
	public static void main(String[] args) throws IOException {
		String path = (TryWithResource.class.getResource("")+"TryWithResource.class").substring(5);
		try (
			// 声明、初始化两个可关闭的资源
			// try语句会自动关闭这两个资源。
			BufferedReader br = new BufferedReader(new FileReader(path));
			PrintStream ps = new PrintStream(new FileOutputStream("a.txt"))) {
			// 使用两个资源
			System.out.println(br.readLine());
			ps.println("输出资源");
		}
	}
}
