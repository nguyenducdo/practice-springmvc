package com.dodo.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.dodo.dto.MyUser;

public class SecurityUtil {
	
	@SuppressWarnings("unchecked")
	public static List<String> getAuthorities() {
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		List<String> results = new ArrayList<String>();
		for(GrantedAuthority authority : authorities) {
			results.add(authority.getAuthority());
		}
		return results;
	}
	
	public static MyUser getPrincipal() {
		MyUser myUser = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return myUser;
	}
}
