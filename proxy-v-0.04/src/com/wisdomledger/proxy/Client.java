package com.wisdomledger.proxy;

public class Client {

	public static void main(String[] args) throws Exception {
		Tank t = new Tank();
		InvocationHandler h = new TimeHandler(t);
		Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class, h);
		m.move();
	}
}
// Can be the proxy of any Object for the methods of any interface