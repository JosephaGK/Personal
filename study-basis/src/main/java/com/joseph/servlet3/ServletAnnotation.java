package com.joseph.servlet3;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Joseph Servlet 3.0增加注解
 */
@WebServlet(name = "HelloServlet", urlPatterns = { "/helloServlet" }, loadOnStartup = 1, initParams = {
		@WebInitParam(name = "userName", value = "joseph"), @WebInitParam(name = "age", value = "18") })
public class ServletAnnotation extends HttpServlet {

	String userName;
	String age;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("=======get test HelloServlet=======");
		resp.getOutputStream()
				.write(("=======get test HelloServlet=======\n userName=" + userName + " age=" + age).getBytes());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("=======post test HelloServlet=======");
		resp.getOutputStream()
				.write(("=======get test HelloServlet=======\n userName=" + userName + " age=" + age).getBytes());
	}
}
