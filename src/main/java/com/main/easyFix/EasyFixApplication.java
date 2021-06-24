package com.main.easyFix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class EasyFixApplication extends SpringBootServletInitializer implements CommandLineRunner {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(EasyFixApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String sql = "INSERT INTO USERS ( APP_USER_DEPARTMENT, EMAIL, ENABLED, FIRST_NAME, LAST_NAME, LOCKED, PASSWORD ) VALUES (" +
			"'ADMIN', 'admin@easyfix.nl', TRUE, 'Admin', 'EasyFix', FALSE, '$2y$12$zgwFyki4zI0WNZl9r9BZZeKIF7DbKoDLI46xJEg6zinwSiyHoyfLy')";

		jdbcTemplate.update(sql);
		System.out.println("Application successfully started!");
	}
}
