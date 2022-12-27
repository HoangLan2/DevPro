/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Dec 8, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devpro.javaweb22.model.Categories;

@Service
public class CategoriesService extends BaseService<Categories> {

	@Override
	protected Class<Categories> clazz() {
		// TODO Auto-generated method stub
		return Categories.class;
	}

	public List<Categories> findAllActive() {
		String sql = "Select * from tbl_category where status = 1";
		return super.executeNativeSql(sql, -1);
	}
}
