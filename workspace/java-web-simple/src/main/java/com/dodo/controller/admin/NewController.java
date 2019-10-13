package com.dodo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewController {
	
	@RequestMapping(value = {"/admin-news/list","/admin-news"}, method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("admin/new/list");
		return mav;
	}
}
