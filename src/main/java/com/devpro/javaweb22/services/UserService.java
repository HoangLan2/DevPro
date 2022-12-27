/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Dec 8, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.services;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.devpro.javaweb22.dto.Constants;
import com.devpro.javaweb22.model.User;

@Service
public class UserService extends BaseService<User> implements Constants {

	@Override
	protected Class<User> clazz() {
		// TODO Auto-generated method stub
		return User.class;
	}

	public User loadUserByUsername(String userName) {
		String sql = "select * from tbl_users u where u.username = '" + userName
				+ "'";
		List<User> users = this.executeNativeSql(sql, -1);
		if (users == null || users.size() <= 0)
			return null;
		return users.get(0);
	}

	@Transactional // đảm bảo tất cả thành công hoặc tất cả thất bại
	public List<User> findAllUser() throws IllegalStateException, IOException {

		// khởi tạo câu lệnh
		String sql = "SELECT * FROM tbl_users where status = '1' order by created_date desc";
		return getEntitiesByNativeSQL(sql);
	}

}
