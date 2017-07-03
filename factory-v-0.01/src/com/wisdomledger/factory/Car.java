package com.wisdomledger.factory;

import java.util.ArrayList;
import java.util.List;

public class Car implements Moveable{
	
	private static Car car= new Car();
	private static List<Car> cars = new ArrayList<Car>();
	
	private Car(){}
	
	public static Car getInstance(){
		return car;
	}
	
	public void run(){
		System.out.println("Car is running...");
	}
}

//Whatever the method is, if the method control the logic to generate object, we can call it factory relative method