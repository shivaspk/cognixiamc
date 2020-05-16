package com.cognixia.filters;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class RouteFilter extends ZuulFilter {
	 
	@Override
	public String filterType() {
		return "route";
	}
	 
	@Override
	public int filterOrder() {
		return 1;
	}
	 
	@Override
	public boolean shouldFilter() {
		return true;
	}
	 
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
	    HttpServletRequest request = ctx.getRequest();
	    System.out.println(request.getContextPath());
		System.out.println("Inside Route Filter");
		return null;
	}

}