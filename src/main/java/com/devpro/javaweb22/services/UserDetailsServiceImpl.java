/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Dec 7, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devpro.javaweb22.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userService.loadUserByUsername(username);
		return user;
	}

}
