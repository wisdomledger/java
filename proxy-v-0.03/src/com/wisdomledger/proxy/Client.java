package com.wisdomledger.proxy;

public class Client {

	public static void main(String[] args) throws Exception{
		Tank t = new Tank();
		Moveable m = (Moveable)Proxy.newProxyInstance(Moveable.class);
		m.move();
	}
}
