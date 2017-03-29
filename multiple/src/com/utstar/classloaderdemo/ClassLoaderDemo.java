package com.utstar.classloaderdemo;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderDemo {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		ClassLoader loader = new ClassLoader() {

			@Override
			public Class<?> loadClass(String name)
					throws ClassNotFoundException {
				try {
					String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
					InputStream in = getClass().getResourceAsStream(fileName);
					if (in == null) {
						return super.loadClass(name);
					}
					byte[] b = new byte[in.available()];
					in.read(b);
					return defineClass(name, b, 0, b.length);
				} catch (IOException e) {
					throw new ClassNotFoundException();
				}
				
			}
			
		};
		Object obj = loader.loadClass("com.utstar.classloaderdemo."
				+ "ClassLoaderDemo").newInstance();
		System.out.println(obj.getClass());
		System.out.println(obj instanceof com.utstar.classloaderdemo.ClassLoaderDemo);
	}
}
