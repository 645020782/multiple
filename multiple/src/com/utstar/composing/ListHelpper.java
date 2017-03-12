package com.utstar.composing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * @author Lenovo
 * 向已有的安全类中添加功能的方法3：扩展功能，新建助手类。
 * 下面的做法是不安全的，因为用到了的不同的锁，所以保证不了原子性。（待验证，不是很理解）
 * 
 * 原意是给安全类list添加新的原子操作，即putIfAbsent，而list是pulbic域的，其他类也可以用到list，
 * 如果有两个线程ListHelpper.list.add和ListHelpper.putIfAbsent就有可能出现错误
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
