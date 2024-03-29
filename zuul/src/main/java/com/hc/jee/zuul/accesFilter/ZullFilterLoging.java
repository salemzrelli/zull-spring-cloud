package com.hc.jee.zuul.accesFilter;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.impl.bootstrap.HttpServer;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZullFilterLoging extends ZuulFilter {
	
	private  Logger logger = org.slf4j.LoggerFactory.getLogger( this.getClass());

	@Override
	public boolean shouldFilter() {
		 
		return  true;
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		
		logger.info(("request ->{} request uri ->{}"), request,request.getRequestURI());
		
		return null;
	}

	@Override
	public String filterType() {
		 
		return  "pre";
	}

	@Override
	public int filterOrder() {
	 
		return 1;
	}

}
