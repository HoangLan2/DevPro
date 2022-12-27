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

import com.devpro.javaweb22.model.Roles;

@Service
public class RoleService extends BaseService<Roles> {

	@Override
	protected Class<Roles> clazz() {
		// TODO Auto-generated method stub
		return Roles.class;
	}

	@Transactional // đảm bảo tất cả thành công hoặc tất cả thất bại
	public Roles findByName(String nameRole)
			throws IllegalStateException, IOException {

		// khởi tạo câu lệnh
		String sql = "SELECT * FROM tbl_roles where status = '1' and name = nameRole";
		return getEntityByNativeSQL(sql);
	}
}
