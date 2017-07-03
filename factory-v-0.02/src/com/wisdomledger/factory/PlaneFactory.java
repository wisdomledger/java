package com.wisdomledger.factory;

public class PlaneFactory extends VehicleFactory{
	public Moveable create(){
		return new Plane();
	}
}
