package com.utstar.collectiontest;

import java.util.ArrayList;

public class Intersection {
	private static ArrayList<String> a = new ArrayList<String>();
	private static ArrayList<String> b = new ArrayList<String>();
	public static void main(String[] args) {
		init();
		ArrayList<String> t = new ArrayList<String>();
		for (int i = 0; i < a.size(); i++) {
			String s = a.get(i);
			if (b.contains(s)) {
				t.add(s);
			}
		}
		for (String x : t) {
			System.out.println(x);
		}
	}
	public static void init() {
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 100; i++) {
				a.add(j + "a" + i);
			}
			a.add("aa" + j);
		}
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 100; i++) {
				b.add(j + "b" + i);
			}
			b.add("aa" + j);
		}
	}
}
