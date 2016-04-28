package com.clear.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @Title: BaseController.java
 * @Description: 基础controller,提供数据类型bind
 */
public class BaseController {
	
	/**
	 * 日期类型转换
	 */
	@InitBinder
    protected void initDateBinder(ServletRequestDataBinder binder) throws ServletException {
		DateFormat df = new SimpleDateFormat("yyyyMMdd");  
		CustomDateEditor editor = new CustomDateEditor(df, true);  
		binder.registerCustomEditor(Date.class, editor);  
    }
	
	/**
	 * 根据传入的map，转换后返回json格式的信息
	 * @param response
	 * @param returnMap
	 */
	protected void responseJsonWriter(HttpServletResponse response, Map<String, Object> returnMap) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().write(this.transformMapToJsonStr(returnMap));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String transformMapToJsonStr(Map<String, Object> returnMap) {
		if (returnMap == null || returnMap.size() == 0)
			return "{}";
		
		StringBuilder resultBuilder = new StringBuilder("{");
		for (Map.Entry<String, Object> entry : returnMap.entrySet()) {
			String key = entry.getKey();
			resultBuilder.append('"').append(key).append('"').append(":").append('"').append(entry.getValue()).append('"').append(",");
		}
		
		String result = resultBuilder.toString().substring(0, resultBuilder.toString().length()-1);
		
		return result + "}";
	}
}
