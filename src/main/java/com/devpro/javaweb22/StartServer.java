/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Nov 8, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Anotation
//-> nhận biết 1 ứng dụng Spring boot
@SpringBootApplication
public class StartServer {

	public static void main(String[] args) {
		// chạy ứng dụng spring boot với class startServer
		SpringApplication.run(StartServer.class, args);
	}
}