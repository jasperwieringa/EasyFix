package com.main.easyFix;

import com.main.easyFix.appuser.AppUser;
import com.main.easyFix.appuser.AppUserRepository;
import com.main.easyFix.customer.Customer;
import com.main.easyFix.customer.CustomerRepository;
import com.main.easyFix.parts.Part;
import com.main.easyFix.parts.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import java.util.List;

@SpringBootApplication
public class EasyFixApplication extends SpringBootServletInitializer {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private AppUserRepository appUserRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private PartRepository partRepository;

	public static void main(String[] args) {
		SpringApplication.run(EasyFixApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	//	TODO: Remove, The loadData method is only used to add some test data for the assignment.
	public void loadData() {
		System.out.println("Pre-populating the database with test data");

		ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator(
			false,
			false,
			"UTF-8",
			new ClassPathResource("data.sql"));
		resourceDatabasePopulator.execute(dataSource);

		List<AppUser> allUsers = appUserRepository.findAll();
		List<Customer> allCustomers = customerRepository.findAll();
		List<Part> allPArts = partRepository.findAll();

		if (allUsers.size() != 0 && allCustomers.size() != 0 && allPArts.size() != 0) {
			System.out.println("Database successfully pre-populated with test data!");
		} else {
			System.out.println("Could not pre-populate database with test data!");
		}
		System.out.println("Application successfully started!");
	}
}
