package com.utstar.classloaderdemo;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class ClassLoaderDemoD {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		System.out.println("ClassLoaderText类的加载器的名称:"+ClassLoaderDemoD.class.getClassLoader().getClass().getName());  
        System.out.println("System类的加载器的名称:"+System.class.getClassLoader());  
        System.out.println("List类的加载器的名称:"+List.class.getClassLoader()); 
        ClassLoader loader = new ClassLoader() {

			@Override
			public Class<?> loadClass(String name)
					throws ClassNotFoundException {
				System.out.println("myLoader!!");
				return super.loadClass(name);
			}
        	
        };
        try {
        	Object o = loader.loadClass("com.utstar.classloaderdemo.ClassLoaderDemoD").newInstance();
	        Class<?> cl = loader.loadClass("com.utstar.classloaderdemo.Test");
	        Object obj = cl.newInstance();
			Method helloMethod = cl.getDeclaredMethod("hello", null);
			helloMethod.invoke(obj, null);
			Class<?> c2 = com.utstar.classloaderdemo.Test.class;
			Object obj2 = cl.newInstance();
			Method helloMethod2 = cl.getDeclaredMethod("hello", null);
			helloMethod2.invoke(obj2, null);
			System.out.println(obj instanceof com.utstar.classloaderdemo.Test);
			System.out.println(o instanceof com.utstar.classloaderdemo.ClassLoaderDemoD);
			System.out.println(ClassLoaderDemoD.class.getClassLoader());
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
