package com.joseph.springmvc.argumentsresolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Joseph
 */
@Controller("/CustomDataBinding")
public class TestCustomDataBinding {
	@RequestMapping("/test")
	public void main(@ModelAttribute CustomDataBinding customDataBinding, @ModelAttribute List<Integer> idList) {
		System.out.println(customDataBinding);
		idList.forEach(e -> System.out.print(e));
	}
}
