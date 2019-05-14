package com.joseph.enumtype;

/**
 * @author Joseph
 */

public enum EnumType {

	/**
	 * 红色
	 */
	RED(1, "红色"),
	/**
	 * 绿色
	 */
	GREEN(2, "绿色");

	private Integer key;
	private String value;

	EnumType(Integer key, String value) {
		this.key = key;
		this.value = value;
	}

	public Integer getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
}
