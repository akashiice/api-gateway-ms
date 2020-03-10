package com.akash.gateway.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class ZuulLoggingFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre"; //intercept all the request before execution
    }

    @Override
    public int filterOrder() {
        return 1; //setting filter order to 1
    }

    @Override
    public boolean shouldFilter() {
        return true; //executing filter for every request
    }

    //log the content of the request
    @Override
    public Object run() throws ZuulException {
        //getting the current HTTP request that is to be handle
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        //prints the detail of the requestin the log
        log.info("request --> {} request url --> {}", request, request.getRequestURI());
        return null;
    }
}
