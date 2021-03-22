package com.gmail.creativegeeksuresh.libraryapp.controller;

import com.gmail.creativegeeksuresh.libraryapp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
    UserService userService;

    @GetMapping(value = { "/", "/login" })
    public ModelAndView signInPage() {
        return new ModelAndView("sign-in");
    }

    @GetMapping(value = "/create-account")
    public ModelAndView createAccountPage() {
        return new ModelAndView("create-account");
    }

    @GetMapping(value = "/user/dashboard")
    public ModelAndView userDashboardPage() {
        return new ModelAndView("user/dashboard");
    }

    @GetMapping(value = "/admin/dashboard")
    public ModelAndView adminDashboardPage() {
        return new ModelAndView("admin/dashboard");
    }

    @GetMapping(value = "/admin/view-users")
    public ModelAndView viewUsersPage() {
        ModelAndView mv = new ModelAndView("admin/view-users");
        mv.addObject("users", userService.getAllUsers());
        return mv;
    }

    @GetMapping(value = "/admin/view-books")
    public ModelAndView viewBooksPage() {
        return new ModelAndView("admin/view-books");
    }

    @GetMapping(value = "/admin/add-book")
    public ModelAndView addBookPage() {
        return new ModelAndView("admin/add-book");
    }

    @GetMapping(value = "/admin/unavailable-books")
    public ModelAndView unavailableBooksPage() {
        return new ModelAndView("admin/unavailable-books");
    }

    @GetMapping(value = "/admin/users-book-request")
    public ModelAndView usersBookRequestPage() {
        return new ModelAndView("admin/users-book-request");
    }
}
