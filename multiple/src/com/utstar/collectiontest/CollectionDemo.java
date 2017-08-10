package com.utstar.collectiontest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionDemo {
	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		LinkedList<String>  l = new LinkedList<String>();
		long bt = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			a.add("a" + i);
			//l.add("l" + i);
		}
		long et = System.currentTimeMillis();
		System.out.println("time : " + (et - bt));
		long bt1 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			//a.add("a" + i);
			l.add("l" + i);
		}
		long et1 = System.currentTimeMillis();
		System.out.println("time1 : " + (et1 - bt1));
		long begin = System.currentTimeMillis();;
		String t = null;
		for (int j = 0; j < a.size(); j++) {
			t = a.get(j);
//			t = s;
		}
		long end = System.currentTimeMillis();;
		System.out.println("a used time : " + (end - begin) + " value : " + t);
		long begin1 = System.currentTimeMillis();;
		for (String s : a) {
			t = s;
		}
		long end1 = System.currentTimeMillis();;
		System.out.println("a zfor used time1 : " + (end1 - begin1) + " value : " + t);
		long begin2 = System.currentTimeMillis();;
		Iterator<String> it = a.iterator();
		while (it.hasNext()) {
			t = it.next();
		}
		long end2 = System.currentTimeMillis();;
		System.out.println("a it used time2 : " + (end2 - begin2) + " value : " + t);
		long b = System.currentTimeMillis();;
		for (String x : l) {
			t = x;
		}
		long e = System.currentTimeMillis();;
		System.out.println("l used time : " + (e - b) + " value : " + t);
	}
}
