package com.dodo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dodo.service.IHomeService;

@Service
public class HomeService implements IHomeService{

	@Override
	public List<String> loadMenu() {
		List<String> menuItems = new ArrayList<String>();
		menuItems.add("Blog java");
		menuItems.add("Hướng dẫn java web");
		menuItems.add("Liên hệ");
		menuItems.add("Thanh toán");
		return menuItems;
	}

}
