package com.wisdomledger.filter;

public class Main {
	public static void main(String[] args) {

		String str = "<hello filter>, bad good great sad";

		Request request = new Request();
		Response response = new Response();

		request.setStrMsg(str);
		response.setStrMsg("response");

		FilterChain fc1 = new FilterChain();
		fc1.addFilter(new A()).addFilter(new B());

		FilterChain fc2 = new FilterChain();
		fc2.addFilter(new C());
		fc1.addFilter(fc2);
		
		fc1.doFilter(request, response, fc1);

		System.out.println(request.getStrMsg());
		System.out.println(response.getStrMsg());
	}
}
