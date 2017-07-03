package com.wisdomledger.filter;

public class B implements Filter {

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		request.strMsg = request.strMsg.replace("bad", "not bad")
				+ " ---B()--- ";
		chain.doFilter(request, response, chain);
		response.strMsg += " ---B()--- ";
	}
}
