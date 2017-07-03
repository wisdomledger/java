package com.wisdomledger.filter;

public class A implements Filter {

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		request.strMsg = request.strMsg.replace("<", "[").replace(">", "]")
				+ " ---A()--- ";
		chain.doFilter(request, response, chain);
		response.strMsg += " ---A()--- ";
	}

}
