package com.dodo.util;

import java.util.HashMap;
import java.util.Map;

public class MessageUtil {
	public static Map<String, String> getMessage(String messageCode){
		if(messageCode==null) {
			return null;
		}
		String message="";
		String alert="";
		if(messageCode.equals("create_success")) {
			message = "CREATE success";
			alert = "success";
		}else if(messageCode.equals("edit_success")) {
			message = "EDIT success";
			alert = "success";
		}else if(messageCode.equals("delete_success")) {
			message = "DELETE success";
			alert = "success";
		}else if(messageCode.equals("error")) {
			message = "System error";
			alert = "danger";
		}
		Map<String, String> result = new HashMap<String, String>();
		result.put("message", message);
		result.put("alert", alert);
		return result;
	}
}
