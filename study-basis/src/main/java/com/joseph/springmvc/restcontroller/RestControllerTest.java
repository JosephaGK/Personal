package com.joseph.springmvc.restcontroller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Joseph
 */
@RestController
@RequestMapping("/RestController")
public class RestControllerTest {
	@RequestMapping("/getJsonObject")
	public JSONObject getJsonObject() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", 1);
		jsonObject.put("name", "gekun");
		return jsonObject;
	}
}
