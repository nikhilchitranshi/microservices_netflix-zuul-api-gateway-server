package com.learning.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class ZuulLoggingFilter extends ZuulFilter{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Override
	public Object run() throws ZuulException {
		
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		
		logger.info("request -> {} request url -> {}",request, request.getRequestURI());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
