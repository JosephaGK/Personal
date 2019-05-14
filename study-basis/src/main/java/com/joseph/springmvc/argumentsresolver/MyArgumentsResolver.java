package com.joseph.springmvc.argumentsresolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.reflect.Field;

/**
 * @author Joseph
 */
public class MyArgumentsResolver implements HandlerMethodArgumentResolver {
	/**
	 * 解析器是否支持当前参数
	 *
	 * @param methodParameter
	 * @return
	 */
	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		// 指定参数如果被应用MyParam注解，则使用该解析器。
		return methodParameter.hasParameterAnnotation(MyParam.class);
		// 如果直接返回true，则代表将此解析器用于所有参数
		//return false;
	}

	@Override
	public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory)
			throws Exception {
		// 获取Controller中的参数名
		String name = methodParameter.getParameterName();
		// 获取Controller中参数的类型
		Class clazz = methodParameter.getParameterType();
		Object arg = null;
		// 获取该参数实体的所用属性
		Field[] fields = clazz.getDeclaredFields();
		// 实例化
		Object target = clazz.newInstance();

		// 创建WebDataBinder对象 反射 遍历fields给属性赋值
		WebDataBinder binder = webDataBinderFactory.createBinder(nativeWebRequest, null, name);
		for (Field field : fields) {
			field.setAccessible(true);
			String fieldName = field.getName();
			Class<?> fieldType = field.getType();
			// 在request中 多对象json数据的key被解析为 user[id] user[realName] info[address] 的这种形式
			String value = nativeWebRequest.getParameter(name + "[" + fieldName + "]");
			arg = binder.convertIfNecessary(value, fieldType, methodParameter);
			field.set(target, arg);
		}
		return target;
	}
}
