package com.wisdomledger.filter;

public class Main {
	public static void main(String[] args) {

		String str = "<hello filter>, bad good great sad";

		MsgProcessor mp = new MsgProcessor();
		mp.setStr(str);
		
		FilterChain fc1 = new FilterChain();
		FilterChain fc2 = new FilterChain();
		fc1.addFilter(new A()).addFilter(new B());
		fc2.addFilter(new C());
		fc1.addFilter(fc2);

		mp.setFc(fc1);

		String r = mp.process();

		System.out.println(r);
	}
}
