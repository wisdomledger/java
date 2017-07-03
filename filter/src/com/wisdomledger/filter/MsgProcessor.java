package com.wisdomledger.filter;

public class MsgProcessor {
	private String str;
	FilterChain fc;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public FilterChain getFc() {
		return fc;
	}

	public void setFc(FilterChain fc) {
		this.fc = fc;
	}

	public String process() {
		return fc.doFilter(str);
	}
}
