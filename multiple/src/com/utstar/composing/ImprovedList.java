package com.utstar.composing;

import java.util.List;
/**
 * @author Lenovo
 * 向已有的安全类中添加功能的方法4：组合。
 * @param <E>
 */
public class ImprovedList<E> {
	private List<E> list;
	public ImprovedList(List<E> list){
		this.list = list;
	}
	public synchronized void putIfAbsent(E x){
		if (! list.contains(x)){
			list.add(x);
		}
	}
}
