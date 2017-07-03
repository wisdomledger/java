package com.wisdomledger.filter;

public class C implements Filter {

	@Override
	public String doFilter(String str) {
		String r = str.replace("sad", "no sad");
		return r;
	}

}
