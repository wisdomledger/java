package com.wisdomledger.factory;

public class CarFactory extends VehicleFactory{
	
	Moveable create() {
		return new Car();
	}
	
}
