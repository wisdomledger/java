package com.wisdomledger.filter;

public class A implements Filter {

	public String doFilter(String str) {
		String r = str.replace("<", "[").replace(">", "]");
		return r;
	}

}
