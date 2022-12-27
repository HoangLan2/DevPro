/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Dec 7, 2022 
 *   @version: 1.0 
*/
package com.devpro.javaweb22.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecureConf extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailService;

	protected void configure(final HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests() // bắt đầu cấu hình security: tất cả các request đều đc bắt trong hàm này

				// tất cả users đều truy cập được. k bị rằng buộc
				.antMatchers("/customer/**", "/css/**", "/js/**", "/manager/**",
						"/login/**", "/logout/**", "/img/**", "/upload/**")
				.permitAll() // tất cả người dùng đều đc vào

				// các request kiểu: "/admin/ phải đăng nhập . chỉ có admin mới được truy cập
				.antMatchers("/admin/**").hasAuthority("ADMIN")

				.and()

				// cấu hình trang đăng nhập
				// login: 1 request trong LoginController được yêu cầu
				.formLogin().loginPage("/login") // nếu yêu cầu /admin/.. mà chưa đc login thì 1 đường dẫn đến /login được mở lên
				.loginProcessingUrl("/perform_login") // sau khi click login chạy vào đây để so sánh code
				.successHandler(authenticationSuccessHandler())
				/* .defaultSuccessUrl("/admin/home", true) */ // sau khi login xong vào trang mặc định admin/index
				.failureUrl("/login?login_error=true").permitAll() // nếu lỗi nhảy vào lại login và thêm tiền tố lõi
				.and()

				// cấu hình cho logout
				.logout().logoutUrl("/logout") // click logout
				.logoutSuccessUrl("/home") // logout thành công trả về trang home
				.invalidateHttpSession(true).deleteCookies("JSESSIONID")
				.permitAll();
	}

	// Encoder(4) độ bảo mật
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailService)
				.passwordEncoder(new BCryptPasswordEncoder(4));
	}

	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new UrlAuthenticationSuccessHandler();
	}

//
	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder(4).encode("admin"));
	}

}
