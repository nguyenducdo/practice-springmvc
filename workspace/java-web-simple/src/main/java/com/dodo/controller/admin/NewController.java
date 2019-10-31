package com.dodo.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dodo.dto.NewDTO;
import com.dodo.service.ICategoryService;
import com.dodo.service.INewService;
import com.dodo.util.MessageUtil;

@Controller
public class NewController {
	
	@Autowired
	private INewService newService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping(value = {"/admin-news/list","/admin-news"}, method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") int page, 
							@RequestParam(value = "limit", defaultValue = "5") int limit,
							HttpServletRequest request) {
//		page = page==null?1:page;
//		limit = limit==null?5:limit;
		ModelAndView mav = new ModelAndView("admin/new/list");
		NewDTO newDTO = new NewDTO();
		Pageable pageable = new PageRequest(page-1, limit);
		newDTO.setList(newService.findAll(pageable));
		newDTO.setStartPage(page);
		newDTO.setTotalItem(newService.getTotalItem());
		newDTO.setTotalPage((int) Math.ceil((double) newDTO.getTotalItem() / limit));
		String messageCode = request.getParameter("message");
		if(messageCode!=null) {
			Map<String, String> map = MessageUtil.getMessage(messageCode);
			mav.addObject("message", map.get("message"));
			mav.addObject("alert", map.get("alert"));
		}
		mav.addObject("newDTO", newDTO);
		return mav;
	}
	
	@RequestMapping(value = "/admin-news/update", method = RequestMethod.GET)
	public ModelAndView createOrEdit(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/new/edit");
		NewDTO newDTO = new NewDTO();
		if(id!=null) {
			newDTO = newService.findOne(id);
		}
		String messageCode = request.getParameter("message");
		if(messageCode!=null) {
			Map<String, String> map = MessageUtil.getMessage(messageCode);
			mav.addObject("message", map.get("message"));
			mav.addObject("alert", map.get("alert"));
		}
		mav.addObject("newDTO", newDTO);
		mav.addObject("categories", categoryService.findAllCodeNameSet());
		return mav;
	}
	
	
}
