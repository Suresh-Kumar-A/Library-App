package com.gmail.creativegeeksuresh.libraryapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LibraryAppApplicationTests {

	@Test
	public void sampleTest(){

	}

	// @Autowired
	// UserService userService;

	// @Autowired
	// BookService bookService;
	
	// // Test Case 1  -- Checking if a user account can be created properly with new user data
	// @Test
	// public void createUserAccountWithoutThrowingAnyError() {
	// 	UserDto testuser = new UserDto();
	// 	testuser.setUsername("testuser");
	// 	testuser.setEmail("testuser@test.com");
	// 	testuser.setPassword("Ram@123");
	// 	assertDoesNotThrow(() -> {
	// 		userService.createUser(testuser);
	// 	});
	// }

	// // Test Case 2  -- Checking if a UserAlreadyExistsException is thrown, if a user with existing username is given
	// @Test
	// public void testUserAlreadyExistsException() {
	// 	UserDto testuser = new UserDto();
	// 	testuser.setUsername("testuser");
	// 	testuser.setEmail("testuser@test.com");
	// 	testuser.setPassword("Ram@123");
	// 	assertThrows(UserAlreadyExistsException.class, () -> {
	// 		userService.createUser(testuser);
	// 	});
	// }

	// // Test Case 3  -- Checking if a new book entry can be created
	// @Test
	// public void addNewBookWithoutThrowingAnyError() {
	// 	BookDto bookDto1 = new BookDto();
	// 	bookDto1.setTitle("Lights of Knowledge");
	// 	bookDto1.setAuthor("Suresh Kumar A");
	// 	bookDto1.setDescription("My life history");
	// 	bookDto1.setAvailable(Boolean.FALSE);
	// 	bookDto1.setPublishedYear(Year.parse("2024"));

	// 	assertDoesNotThrow(() -> {
	// 		bookService.addBook(bookDto1);
	// 	});
	// }

	// // Test Case 4  -- Checking if a BookAlreadyExistsException is thrown, if a new book with existing title is given
	// @Test
	// public void testBookAlreadyExistsException() {
	// 	BookDto bookDto1 = new BookDto();
	// 	bookDto1.setTitle("Wings of Fire");
	// 	bookDto1.setAuthor("Dr. APJ Kalam");
	// 	bookDto1.setDescription("Good BookDto for youngsters");
	// 	bookDto1.setAvailable(Boolean.TRUE);
	// 	bookDto1.setPublishedYear(Year.parse("1999"));
	// 	assertThrows(BookAlreadyExistsException.class, () -> {
	// 		bookService.addBook(bookDto1);
	// 	});
	// }

}
