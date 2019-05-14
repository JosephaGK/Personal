package com.joseph.springmvc.argumentsresolver;

import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author Joseph
 * 注册自己写的处理类
 */
@Component
public class WebMvcConfig implements WebMvcConfigurer {
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		// 配置自定义接收参数
		WebMvcConfigurer.super.addArgumentResolvers(resolvers);
		resolvers.add(new MyArgumentsResolver());
	}
}
