package com.gmail.creativegeeksuresh.libraryapp.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import com.gmail.creativegeeksuresh.libraryapp.dto.BookDto;
import com.gmail.creativegeeksuresh.libraryapp.dto.BookRequestDto;
import com.gmail.creativegeeksuresh.libraryapp.dto.UserDto;
import com.gmail.creativegeeksuresh.libraryapp.exception.UserAlreadyExistsException;
import com.gmail.creativegeeksuresh.libraryapp.service.BookRequestService;
import com.gmail.creativegeeksuresh.libraryapp.service.BookService;
import com.gmail.creativegeeksuresh.libraryapp.service.UserService;
import com.gmail.creativegeeksuresh.libraryapp.service.util.CustomPdfService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @Autowired
    BookRequestService bookRequestService;

    @Autowired
    CustomPdfService customPdfService;

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

    @PostMapping(value = "/admin/upload-book-contents", consumes = "multipart/form-data")
    public ResponseEntity<?> uploadBookContents(@RequestParam("book") MultipartFile file) {
        try {
            customPdfService.createFile(file.getInputStream());
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (Exception ex) {
            System.err.println(ex.getLocalizedMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/admin/read-pdf")
    public ResponseEntity<?> readPdf() {
        try {

            Path path = Paths.get("E:\\adobedata.pdf").toAbsolutePath().normalize();

            Resource resource = new UrlResource(path.toUri());

            return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/pdf")).body(resource);


            // #toolbar=0   -- use to prevent download option in chrome browser
            // Working
            // return new ResponseEntity<>(resource, HttpStatus.OK);
        } catch (Exception ex) {
            System.err.println(ex.getLocalizedMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
