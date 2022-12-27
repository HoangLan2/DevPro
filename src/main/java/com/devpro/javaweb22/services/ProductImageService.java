/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Dec 8, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.services;

import org.springframework.stereotype.Service;

import com.devpro.javaweb22.model.ProductImages;

@Service
public class ProductImageService extends BaseService<ProductImages> {

	@Override
	protected Class<ProductImages> clazz() {
		// TODO Auto-generated method stub
		return ProductImages.class;
	}

}
