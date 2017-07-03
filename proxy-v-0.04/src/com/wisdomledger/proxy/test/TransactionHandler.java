package com.wisdomledger.proxy.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.wisdomledger.proxy.InvocationHandler;

public class TransactionHandler implements InvocationHandler {

	private Object target;

	public TransactionHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public void invoke(Object o, Method m) {
		System.out.println("Transaction start");
		try {
			m.invoke(target);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println("Transaction commit");
	}

}
