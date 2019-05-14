package com.joseph.springmvc.databind;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Joseph
 */
@Controller
@RequestMapping("/databind")
public class MyController {

	@InitBinder
	protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping("/baseType")
	@ResponseBody
	public String baseType(String string, Integer integer, Double dou, Date date) {
		JSONObject jo = new JSONObject();
		jo.put("String", string);
		jo.put("Integer", integer);
		jo.put("Double", dou);
		jo.put("Date", date);
		System.out.println(jo.toJSONString());
		return jo.toJSONString();
	}

	@RequestMapping("/list")
	@ResponseBody
	public String baseType(List<String> list) {
		JSONObject jo = new JSONObject();
		jo.put("list", list);
		return jo.toJSONString();
	}

	@RequestMapping("/pathVarible/{pathVarible}")
	@ResponseBody
	public String pathVarible(@PathVariable String pathVarible) {
		JSONObject jo = new JSONObject();
		jo.put("pathVarible", pathVarible);
		return jo.toJSONString();
	}

	@RequestMapping("/sessionAttribute")
	@ResponseBody
	public String sessionAttribute(@SessionAttribute String id) {
		JSONObject jo = new JSONObject();
		jo.put("SessionAttribute", id);
		return jo.toJSONString();
	}

}
