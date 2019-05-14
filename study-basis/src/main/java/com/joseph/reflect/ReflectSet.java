package com.joseph.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ReflectSet {

	public static final Object setGeneralSettins(Object object)throws InvocationTargetException, IllegalAccessException {
		Method[] methods = object.getClass().getMethods();
		for (Method method : methods) {
			if (method.getName().equals("setCreatedId")) {
				method.invoke(object,"创建人");
			}else if(method.getName().equals("setCreatedDate")){
				method.invoke(object,"创建时间");
			}else if(method.getName().equals("setUpdatedId")){
				method.invoke(object,"更新人");
			}else if(method.getName().equals("setUpdatedDate")){
				method.invoke(object,"更新时间");
			}
		}
		return object;
	}
	public static void main(String[] arg) throws InvocationTargetException, IllegalAccessException {
		ReflectSetDomain domain = new ReflectSetDomain();
		ReflectSetDomain o = (ReflectSetDomain)setGeneralSettins(domain);
		System.out.println(o);
	}

}
