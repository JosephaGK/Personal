package com.joseph.streams;

import lombok.Data;

@Data
public class User {
	private Integer id;
	private String name;

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}
}
