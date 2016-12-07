package com.utstar.notifywait;

import java.util.ArrayList;
import java.util.List;

public class MyList {
	public static List<String> list = new ArrayList<String>();
	public static void add(){
		list.add("item");
	}
	public static int size(){
		return list.size();
	}
}
