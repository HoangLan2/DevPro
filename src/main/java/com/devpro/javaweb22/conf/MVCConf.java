/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 15, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.devpro.javaweb22.dto.Constants;

//Bước số 2 khi tích một spring module vào spring-boot project đó là cấu hình module đó
//1. Báo cho spring biết đây là 1 file cấu hình
//2. Tạo ra một Bean và được quản lí bởi spring-container

@Configuration
public class MVCConf implements WebMvcConfigurer, Constants {
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {

		// ERROR: http://localhost:8080/css/styles.css 404
		// bất cứ request nào có dạng: http://localhost:8080/css/thumuccon/dcf.css sẽ vào folder
		// src/main/resources/css
		// classpath: = /src/main/resources
		registry.addResourceHandler("/css/**")
				.addResourceLocations("classpath:/css/");

		// ERROR: http://localhost:8080/js/scripts.js 404
		// bất cứ request nào có dạng: http://localhost:8080/js/thumuccon/dcf.js sẽ vào folder
		// src/main/resources/js
		registry.addResourceHandler("/js/**")
				.addResourceLocations("classpath:/js/");
		registry.addResourceHandler("/img/**")
				.addResourceLocations("classpath:/img/");

		registry.addResourceHandler("/manager/**")
				.addResourceLocations("classpath:/manager/");
		registry.addResourceHandler("/css/**")
				.addResourceLocations("classpath:/css/");

		registry.addResourceHandler("/user/**")
				.addResourceLocations("classpath:/user/");
		registry.addResourceHandler("/Font/**")
				.addResourceLocations("classpath:/Font/");

		// đăng kí thêm folder upload
		registry.addResourceHandler("/upload/**")
				.addResourceLocations("file:" + UPLOAD_FOLDER_ROOT);
	}

	@Bean
	public ViewResolver viewResolver() {

		// Class InternalResourceViewResolver implements ViewResolver
		InternalResourceViewResolver bean = new InternalResourceViewResolver();

		// thiết lập view engine
		bean.setViewClass(JstlView.class);

		// Đường dẫn thư mực gốc chứa Views.
		bean.setPrefix("/WEB-INF/views/");

		// Tên đuôi của View
		bean.setSuffix(".jsp");

		return bean;

	}

}
