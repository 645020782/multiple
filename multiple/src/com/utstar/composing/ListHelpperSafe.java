package com.utstar.composing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * @author Lenovo
 * 向已有的安全类中添加功能的方法3：扩展功能，新建助手类。
 * @param <E>
 */
public class ListHelpperSafe<E> {
	public List<E> list = Collections.synchronizedList(new ArrayList<E>());
	public void putIfAbsent(E x){
		synchronized (list){
			if (! list.contains(x)){
				list.add(x);
			}
		}
	}
}
