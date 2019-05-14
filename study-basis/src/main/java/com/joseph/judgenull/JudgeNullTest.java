package com.joseph.judgenull;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author Joseph
 */
public class JudgeNullTest {
	public static void main(String[] arg){
	    //String判断为空
		String nullString= null;
		String zeroSizeString = "";
		String whitespaceString = "  ";
		System.out.println("StringUtils.isEmpty() nullString:"+StringUtils.isEmpty(nullString));
		System.out.println("StringUtils.isBlank() nullString:"+StringUtils.isBlank(nullString));
		System.out.println("StringUtils.isEmpty() zeroSizeString:"+StringUtils.isEmpty(zeroSizeString));
		System.out.println("StringUtils.isBlank() zeroSizeString:"+StringUtils.isBlank(zeroSizeString));
		System.out.println("StringUtils.isEmpty() whitespaceString:"+StringUtils.isEmpty(whitespaceString));
		System.out.println("StringUtils.isBlank() whitespaceString:"+StringUtils.isBlank(whitespaceString));

		//集合判断为空
		List<String> nullList = null;
		List<String> memberNullList = Arrays.asList(null,null);
		System.out.println("CollectionUtils.isEmpty() memberNullList:"+CollectionUtils.isEmpty(memberNullList));
		System.out.println("isEmpty() memberNullList:"+memberNullList.isEmpty());
		System.out.println("CollectionUtils.isEmpty() nullList:"+CollectionUtils.isEmpty(nullList));
		System.out.println("isEmpty() nullList:"+nullList.isEmpty());

	}
}
