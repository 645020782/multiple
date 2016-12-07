package com.utstar.prosum;

public class ValueObject {
	volatile public static String value = "";

	public static String getValue() {
		return value;
	}

	public static void setValue(String value) {
		ValueObject.value = value;
	}
	
}
