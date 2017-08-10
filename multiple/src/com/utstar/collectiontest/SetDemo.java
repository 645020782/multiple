package com.utstar.collectiontest;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
	public static void main(String[] args) {
		/*Set<String> s = new HashSet<String>();
		for (int i = 0; i < 10; i++) {
			s.add("t" + i);
		}
		for (String a : s) {
			System.out.println(a);
		}*/
		Set<String> l = new LinkedHashSet<String>();
		for (int i = 10; i > 0; i--) {
			l.add("l" + i);
		}
		for (String a : l) {
			System.out.print(a + " ");
		}
		System.out.println();
		Set<String> t = new TreeSet<String>();
		for (int i = 10; i > 0; i--) {
			t.add("l" + i);
		}
		for (String a : t) {
			System.out.print(a + " ");
		}
	}
}
