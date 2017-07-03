package com.wisdomledger.factory;

public class Test {
	public static void main(String[] args) {
		//Car c = Car.getInstance();
		//Car c2 = Car.getInstance();
		PlaneFactory factory = new PlaneFactory();
		Moveable m = factory.createPlane();
		m.run();
	}
}

