/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Dec 14, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.services;

import org.springframework.stereotype.Service;

import com.devpro.javaweb22.dto.Constants;
import com.devpro.javaweb22.model.User;

@Service
public class RegisterService extends BaseService<User> implements Constants {

	@Override
	protected Class<User> clazz() {
		return User.class;
	}

}
