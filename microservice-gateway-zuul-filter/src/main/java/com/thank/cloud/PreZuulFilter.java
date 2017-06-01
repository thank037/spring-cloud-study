package com.thank.cloud;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreZuulFilter extends ZuulFilter{

	/**
	 * 过滤器执行的具体业务逻辑
	 */
	@Override
	public Object run() {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		String host = request.getRemoteHost();
		System.out.println("请求的host: " + host);
		return null;
	}

	/**
	 * 是否要启用这个过滤器
	 * false: 不用
	 * true: 用
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 过滤器执行的优先级, 数字越小优先级越高
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	
	/**
	 * 过滤器的类型 
	 */
	@Override
	public String filterType() {
		return "pre";
	}

}
