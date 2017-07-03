package com.wisdomledger.factory.abstractfactory;

public class Test {
	
	public static void main(String[] args) {
		AbstractFactory f = new MagicFactory();
		
		Vehicle v = f.createVehicle();
		v.run();
		
		Weapon w = f.createWeapon();
		w.shoot();
		
		Food food = f.createFood();
		food.printName();
		
	}
}

