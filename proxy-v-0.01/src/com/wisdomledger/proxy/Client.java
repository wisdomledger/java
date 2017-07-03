package com.wisdomledger.proxy;

public class Client {

	public static void main(String[] args) {
		Tank t = new Tank();
		Moveable m1 = new TankLogProxy(t);
		Moveable m2 = new TankTimeProxy(m1);
		m2.move();
	}
}
