package com.wisdomledger.filter;

public class B implements Filter {

	public String doFilter(String str) {
		String r = str.replace("bad", "not bad");
		return r;
	}
}
