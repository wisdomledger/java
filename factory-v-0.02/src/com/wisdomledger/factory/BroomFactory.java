package com.wisdomledger.factory;

public class BroomFactory extends VehicleFactory{
	
	Moveable create() {
		return new Broom();
	}
	
}
