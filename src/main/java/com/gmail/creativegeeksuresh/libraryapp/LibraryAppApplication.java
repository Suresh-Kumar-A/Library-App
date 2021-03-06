package com.gmail.creativegeeksuresh.libraryapp;

import com.gmail.creativegeeksuresh.libraryapp.model.Role;
import com.gmail.creativegeeksuresh.libraryapp.service.BookService;
import com.gmail.creativegeeksuresh.libraryapp.service.RoleService;
import com.gmail.creativegeeksuresh.libraryapp.service.UserService;
import com.gmail.creativegeeksuresh.libraryapp.service.util.AppConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryAppApplication implements CommandLineRunner {

	@Value("${default.admin.username}")
	private String adminUsername;

	@Value("${default.admin.password}")
	private String adminPassword;

	@Value("${default.admin.email}")
	private String adminEmail;

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	@Autowired
	BookService bookService;


	public static void main(String[] args) {
		SpringApplication.run(LibraryAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {

			// checking if all role exists otherwise adding them
			if (roleService.getAllRoles().size() == 0) {
				AppConstants.ROLE_SET.forEach(roleName -> {
					try {
						Role role = new Role();
						role.setRoleName(roleName);
						roleService.createRole(role);
					} catch (Exception e) {
						System.err.println(e.getLocalizedMessage());
						e.printStackTrace();
					}
				});
			}

			userService.createAdminUser(adminUsername, adminPassword, adminEmail);

			// Creating default Book set
			if (bookService.getAllBooks().size() == 0) {
				AppConstants.DEFAULT_DATA_LIST.forEach(book -> {
					try {
						bookService.addBook(book);
					} catch (Exception e) {
						System.err.println(e.getLocalizedMessage());
						e.printStackTrace();
					}
				});
			}

		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}

	}

}
