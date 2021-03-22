package com.gmail.creativegeeksuresh.libraryapp.controller;

import java.util.HashMap;

import com.gmail.creativegeeksuresh.libraryapp.dto.BookDto;
import com.gmail.creativegeeksuresh.libraryapp.dto.BookRequestDto;
import com.gmail.creativegeeksuresh.libraryapp.dto.UserDto;
import com.gmail.creativegeeksuresh.libraryapp.exception.UserAlreadyExistsException;
import com.gmail.creativegeeksuresh.libraryapp.service.BookRequestService;
import com.gmail.creativegeeksuresh.libraryapp.service.BookService;
import com.gmail.creativegeeksuresh.libraryapp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @Autowired
    BookRequestService bookRequestService;

    @PostMapping(value = "/create-account")
    public ResponseEntity<?> createUserAccount(@RequestBody UserDto request) {
        try {
            return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
        } catch (UserAlreadyExistsException uaex) {
            System.err.println(uaex.getLocalizedMessage());
            return new ResponseEntity<>(uaex.getLocalizedMessage(), HttpStatus.CONFLICT);
        } catch (Exception ex) {
            System.err.println(ex.getLocalizedMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/admin/delete-user")
    public ResponseEntity<?> deleteUserAccount(@RequestParam String username) {
        try {
            userService.deleteUserByUsername(username);
            return new ResponseEntity<>(new HashMap<>(), HttpStatus.OK);
        } catch (UserAlreadyExistsException uaex) {
            System.err.println(uaex.getLocalizedMessage());
            return new ResponseEntity<>(uaex.getLocalizedMessage(), HttpStatus.CONFLICT);
        } catch (Exception ex) {
            System.err.println(ex.getLocalizedMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/admin/add-book")
    public ResponseEntity<?> addBookEntry(@RequestBody BookDto request) {
        try {
            return new ResponseEntity<>(bookService.addBook(request), HttpStatus.CREATED);
        } catch (UserAlreadyExistsException uaex) {
            System.err.println(uaex.getLocalizedMessage());
            return new ResponseEntity<>(uaex.getLocalizedMessage(), HttpStatus.CONFLICT);
        } catch (Exception ex) {
            System.err.println(ex.getLocalizedMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/admin/update-book")
    public ResponseEntity<?> updateBookEntry(@RequestBody BookDto request) {
        try {
            return new ResponseEntity<>(bookService.updateBook(request), HttpStatus.OK);
        } catch (UserAlreadyExistsException uaex) {
            System.err.println(uaex.getLocalizedMessage());
            return new ResponseEntity<>(uaex.getLocalizedMessage(), HttpStatus.CONFLICT);
        } catch (Exception ex) {
            System.err.println(ex.getLocalizedMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get-all-books")
    public ResponseEntity<?> getAllBooks() {
        try {
            return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
        } catch (Exception ex) {
            System.err.println(ex.getLocalizedMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/user/add-book-request")
    public ResponseEntity<?> addBookAcessRequest(@RequestBody BookRequestDto request) {
        try {
            return new ResponseEntity<>(bookRequestService.createRequest(request), HttpStatus.CREATED);
        } catch (UserAlreadyExistsException uaex) {
            System.err.println(uaex.getLocalizedMessage());
            return new ResponseEntity<>(uaex.getLocalizedMessage(), HttpStatus.CONFLICT);
        } catch (Exception ex) {
            System.err.println(ex.getLocalizedMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/admin/delete-book")
    public ResponseEntity<?> deleteBookAccount(@RequestParam String uid) {
        try {
            bookService.deleteBookByUid(uid);
            return new ResponseEntity<>(new HashMap<>(), HttpStatus.OK);
        } catch (UserAlreadyExistsException uaex) {
            System.err.println(uaex.getLocalizedMessage());
            return new ResponseEntity<>(uaex.getLocalizedMessage(), HttpStatus.CONFLICT);
        } catch (Exception ex) {
            System.err.println(ex.getLocalizedMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/admin/allow-book-access")
    public ResponseEntity<?> allowBookAccess(@RequestParam String uid) {
        try {
            bookRequestService.updateBookAvailablityAndDeleteRequest(uid);
            return new ResponseEntity<>(new HashMap<>(), HttpStatus.OK);
        } catch (UserAlreadyExistsException uaex) {
            System.err.println(uaex.getLocalizedMessage());
            return new ResponseEntity<>(uaex.getLocalizedMessage(), HttpStatus.CONFLICT);
        } catch (Exception ex) {
            System.err.println(ex.getLocalizedMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
