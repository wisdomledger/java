package com.wisdomledger.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {
	
	private Object target;
	
	public TimeHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public void invoke(Object o, Method m) {

		long start = System.currentTimeMillis();
		System.out.println("Tank start at time: " + start);

		try {
			m.invoke(target);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		System.out.println("Tank total moving time: " + (end - start));
	}

}
