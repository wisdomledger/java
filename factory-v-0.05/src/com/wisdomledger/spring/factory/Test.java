package com.wisdomledger.spring.factory;

import java.util.Properties;

public class Test {

	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.load(Test.class.getClassLoader().getResourceAsStream(
				"com/wisdomledger/spring/factory/spring.properties"));
		String vehicleTypeName = props.getProperty("VehicleType");
		Object o = Class.forName(vehicleTypeName).newInstance();
		Moveable m = (Moveable) o;
		m.run();
	}

}
