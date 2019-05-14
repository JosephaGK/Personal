package com.joseph.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streams {
	public static void main(String[] arg) {
		debugg();
	}

	public static void debugg() {
		//使用idea提供的Trace Current Stream Chain进行stream的debug
		List<String> strings = Stream.of("C", "A", "B").sorted().collect(Collectors.toList());
	}

	public static void listObjTomapIntergerObj() {
		List<User> users = Arrays.asList(new User(1, "Tomcat"), new User(2, "Apache"), new User(3, "Nginx"));
		//方法一
		Map<Integer, User> map = users.stream().collect(Collectors.toMap(obj -> obj.getId(), obj -> obj));
		//方法二maven-compiler-plugin
		//Map<Integer, User> map = users.stream().collect(Collectors.toMap(User::getId , obj -> obj));
		System.out.println(map);
	}

	public static void listMapTolistString() {
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map1 = new HashMap<>();
		map1.put("id", "101");
		map1.put("name", "Tomcat");
		Map<String, String> map2 = new HashMap<>();
		map2.put("id", "102");
		map2.put("name", "Apache");
		Map<String, String> map3 = new HashMap<>();
		map3.put("id", "103");
		map3.put("name", "Nginx");
		list.add(map1);
		list.add(map2);
		list.add(map3);
		//方法一
		List<String> ids = list.stream().map(entity -> entity.get("id")).collect(Collectors.toList());
		//方法二
		//List<Object> ids = Arrays.asList(list.stream().map(entity -> entity.get("id")).toArray());
		System.out.println(ids);
	}

	public static void strTomap() {
		String str = "type=1&from=APP&source=homePage";
		Map<String, String> map = Stream.of(str.split("&")).map(obj -> obj.split("=")).collect(Collectors.toMap(entry -> entry[0], entry -> entry[1]));
		System.out.println(map);
	}

	public static void listStrTolistInteger() {
		List<String> strs = Arrays.asList("1", "2", "3");
		List<Integer> ints = strs.stream().map(obj -> Integer.valueOf(obj)).collect(Collectors.toList());
	}

}
