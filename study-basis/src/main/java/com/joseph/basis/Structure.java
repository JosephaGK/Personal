package com.joseph.basis;

public class Structure {
	public static Structure t1 = new Structure();
	public static Structure t2 = new Structure();

	{
		System.out.println("构造块");
	}

	static {
		System.out.println("静态块");
	}

	public static void main(String[] args) {
		Structure structure = new Structure();
	}

}
