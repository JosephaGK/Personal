package com.joseph.lambda.MethodRef;

import lombok.Data;

import java.util.Objects;

@Data
public class Employee {
	private int id;
	private String name;
	private int age;
	private double salary;

	public Employee() {
	}

	public Employee(String name) {
		this.name = name;
	}

	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Employee(int id, String name, int age, double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	public String show() {
		return "测试方法引用！";
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Employee employee = (Employee) o;
		return id == employee.id && age == employee.age && Double.compare(employee.salary, salary) == 0 && Objects
				.equals(name, employee.name);
	}

	@Override public int hashCode() {

		return Objects.hash(id, name, age, salary);
	}
}
