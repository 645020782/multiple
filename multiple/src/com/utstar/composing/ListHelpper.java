package com.utstar.composing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * @author Lenovo
 * 向已有的安全类中添加功能的方法3：扩展功能，新建助手类。
 * 下面的做法是不安全的，因为用到了的不同的锁，所以保证不了原子性。（待验证，不是很理解）
 * @param <E>
 */
public class ListHelpper<E> {
	public List<E> list = Collections.synchronizedList(new ArrayList<E>());
	public synchronized void putIfAbsent(E x){
		if (! list.contains(x)){
			list.add(x);
		}
	}
}
