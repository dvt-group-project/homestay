package com.thinkpad.homestay;

import com.thinkpad.homestay.formatter.UserRoleFormatter;
import com.thinkpad.homestay.services.*;
import com.thinkpad.homestay.services.impl.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class HomestayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomestayApplication.class, args);
	}

	@Bean
	public ImageHouseService imageHouseService() {
		return new ImageHouseServiceImpl();
	}

	@Bean
	public UserRoleService userRoleService() {
		return new UserRoleServiceImpl();
	}

	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Configuration
	static class MyConfig extends WebMvcConfigurerAdapter {
		@Override
		public void addFormatters(FormatterRegistry registry) {
			registry.addFormatter(new UserRoleFormatter());
		}
	}

	@Bean
	public HouseService houseService() {
		return new HouseServiceImpl();
	}
	@Bean
	public ReservationService reservationService() {
		return new ReservationServiceImpl();
	}
}

