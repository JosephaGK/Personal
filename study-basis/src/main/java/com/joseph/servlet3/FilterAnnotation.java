package com.joseph.servlet3;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @author Joseph
 */
@WebFilter(filterName = "myFilter", urlPatterns = { "/*" }, initParams = {
		@WebInitParam(name = "ref", value = "test") })
public class FilterAnnotation implements Filter {
	/**
	 * 初始化过滤器
	 * @param config
	 * @throws ServletException
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		// 取得初始化参数
		String initParam = config.getInitParameter("ref");
		System.out.println("=========webfilter=======");
		System.out.println("** 过滤器初始化，初始化参数 = " + initParam);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("** 执行doFilter()方法之前。");
		// 将请求继续传递
		chain.doFilter(request, response);
		System.out.println("** 执行doFilter()方法之后。");
	}

	@Override
	public void destroy() {
		System.out.println("*========过滤器销毁=========");
	}

}
