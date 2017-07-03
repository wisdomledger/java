package com.wisdomledger.proxy.test;

import com.wisdomledger.proxy.InvocationHandler;
import com.wisdomledger.proxy.Proxy;

public class Clinet {

	public static void main(String[] args) throws Exception {
		UserMgr mgr = new UserMgrImpl();
		InvocationHandler h = new TransactionHandler(mgr);
		UserMgr u = (UserMgr)Proxy.newProxyInstance(UserMgr.class, h);
		u.addUser();
	}
}
