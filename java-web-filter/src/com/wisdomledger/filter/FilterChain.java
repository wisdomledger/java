package com.wisdomledger.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {
	List<Filter> filters = new ArrayList<Filter>();
	int index;

	public FilterChain addFilter(Filter f) {
		this.filters.add(f);
		return this;
	}

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		if (index == filters.size())
			return;
		Filter f = filters.get(index);
		index++;
		f.doFilter(request, response, chain);
	}

}
