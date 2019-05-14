package com.joseph.jep;

import org.nfunk.jep.JEP;

/**
 * @author Joseph
 */
public class JepUtil {
	public static void main(String[] arg){
		JEP jep = new JEP();
		//设置公式
		String expression = "((a+b)*(c+b))/(c+a)/b";
		//变量赋值
		jep.addVariable("a",10);
		jep.addVariable("b",10);
		jep.addVariable("c",10);
		//运算
		jep.parseExpression(expression);
		//结果
		System.out.println(jep.getValue());
	}

}
