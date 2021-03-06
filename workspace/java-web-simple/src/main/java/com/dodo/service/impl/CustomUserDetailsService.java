package com.dodo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dodo.constant.SystemConstant;
import com.dodo.dto.MyUser;
import com.dodo.entity.RoleEntity;
import com.dodo.entity.UserEntity;
import com.dodo.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);
		if(userEntity == null) {
			throw new UsernameNotFoundException("User not found");
		}
		//Nếu authentication thành công, put thông tin vào security để duy trì thông tin (~Session)
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(RoleEntity role : userEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		MyUser myUser = new MyUser(userEntity.getUsername(), userEntity.getPassword(), authorities);
		myUser.setFullName(userEntity.getFullname());
		return myUser;
	}

}















