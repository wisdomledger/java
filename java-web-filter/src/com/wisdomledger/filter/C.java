package com.wisdomledger.filter;

public class C implements Filter {
	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		request.strMsg = request.strMsg.replace("sad", "no sad")
				+ " ---C()--- ";
		chain.doFilter(request, response, chain);
		response.strMsg += " ---C()--- ";
	}

}
