package com.wisdomledger.proxy;

public class TankTimeProxy implements Moveable {

	Moveable t;

	public TankTimeProxy(Moveable t) {
		super();
		this.t = t;
	}

	@Override
	public void move() {
		long start = System.currentTimeMillis();
		System.out.println("Tank start at time: " + start);
		t.move();
		long end = System.currentTimeMillis();
		System.out.println("Tank total moving time: " + (end - start));
	}

}
