package com.wisdomledger.proxy.test;

public class UserMgrImpl implements UserMgr{
	@Override
	public void addUser() {
		System.out.println("1.Insert records into table user");
		System.out.println("2.Do log in another table");
	}
}
