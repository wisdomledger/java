package com.wisdomledger.factory;

public class Test {
	public static void main(String[] args) {
		//Car c = Car.getInstance();
		//Car c2 = Car.getInstance();
		VehicleFactory factory = new BroomFactory();
		Moveable m = factory.create();
		m.run();
	}
}

