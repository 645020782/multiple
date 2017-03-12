package com.utstar.composing;

import java.util.Vector;

/**
 * @author Lenovo
 * 向已有的安全类中添加功能的方法2：通过继承线程安全类，来添加新的原子功能
 * @param <E>
 */
public class BetterVectot<E> extends Vector<E>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public synchronized void putIfAbsent(E x){
		if(!contains(x)){
			add(x);
		}
	}

}
