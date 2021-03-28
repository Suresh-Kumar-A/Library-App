package com.gmail.creativegeeksuresh.libraryapp.controller;

import com.gmail.creativegeeksuresh.libraryapp.service.BookRequestService;
import com.gmail.creativegeeksuresh.libraryapp.service.BookService;
import com.gmail.creativegeeksuresh.libraryapp.service.UserService;
import com.gmail.creativegeeksuresh.libraryapp.service.util.CustomUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @Autowired
    CustomUtils customUtils;

    @Autowired
    BookRequestService bookRequestService;

    @GetMapping(value = { "/", "/login" })
    public ModelAndView signInPage() {
        return new ModelAndView("sign-in");
    }

    @GetMapping(value = "/create-account")
    public ModelAndView createAccountPage() {
        return new ModelAndView("create-account");
    }

    @GetMapping(value = "/user/view-books")
    public ModelAndView viewBooksUserPage() {
        ModelAndView mv = new ModelAndView("user/view-books");
        mv.addObject("bookList", bookService.getAllBooks());
        return mv;
    }

    @GetMapping(value = "/admin/dashboard")
    public ModelAndView adminDashboardPage() {
        ModelAndView mv = new ModelAndView("admin/dashboard");
        return mv;
    }

    @GetMapping(value = "/admin/view-users")
    public ModelAndView viewUsersPage() {
        ModelAndView mv = new ModelAndView("admin/view-users");
        mv.addObject("userList", userService.getAllUsers());
        return mv;
    }

    @GetMapping(value = "/admin/view-books")
    public ModelAndView viewBooksPage() {
        ModelAndView mv = new ModelAndView("admin/view-books");
        mv.addObject("bookList", bookService.getAllBooks());
        return mv;
    }

    @GetMapping(value = "/admin/add-book")
    public ModelAndView addBookPage() {
        ModelAndView mv = new ModelAndView("admin/add-book");

        return mv;
    }

    @GetMapping(value = "/admin/edit-book")
    public ModelAndView editBookPage(@RequestParam String uid) {
        ModelAndView mv = new ModelAndView("admin/edit-book");
        mv.addObject("book", bookService.findByUid(uid));

        return mv;
    }

    @GetMapping(value = "/admin/unavailable-books")
    public ModelAndView unavailableBooksPage() {
        ModelAndView mv = new ModelAndView("admin/unavailable-books");
        mv.addObject("books", bookService.getAllUnavilableBooks());

        return mv;
    }

    @GetMapping(value = "/admin/users-book-request")
    public ModelAndView usersBookRequestPage() {
        ModelAndView mv = new ModelAndView("admin/users-book-request");

        mv.addObject("requestList", bookRequestService.getAllBooks());
        return mv;
    }

    @GetMapping(value = "/error/page-unavailable")
    public ModelAndView pageUnavailablePage() {
        return new ModelAndView("error/page-not-found");
    }

    @GetMapping(value = "/error/internal-server-error")
    public ModelAndView internalServerErrorPage() {
        return new ModelAndView("error/internal-server-error");
    }

}
