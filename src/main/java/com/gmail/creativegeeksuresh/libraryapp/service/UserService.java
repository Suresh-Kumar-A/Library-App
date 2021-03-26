package com.gmail.creativegeeksuresh.libraryapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gmail.creativegeeksuresh.libraryapp.dto.UserDto;
import com.gmail.creativegeeksuresh.libraryapp.exception.InvalidUserException;
import com.gmail.creativegeeksuresh.libraryapp.exception.UserAlreadyExistsException;
import com.gmail.creativegeeksuresh.libraryapp.model.Role;
import com.gmail.creativegeeksuresh.libraryapp.model.User;
import com.gmail.creativegeeksuresh.libraryapp.repository.UserRepository;
import com.gmail.creativegeeksuresh.libraryapp.service.util.AppConstants;
import com.gmail.creativegeeksuresh.libraryapp.service.util.CustomUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CustomUtils customUtils;

    @Autowired
    private RoleService roleService;

    public User createUser(UserDto request) throws UserAlreadyExistsException, Exception {
        if (userRepo.findByUsernameOrEmail(request.getUsername(), request.getEmail()).size() != 0)
            throw new UserAlreadyExistsException("User with similar data exists");
        User newUser = new User();
        newUser.setUsername(request.getUsername());
        newUser.setEmail(request.getEmail());
        newUser.setPassword(customUtils.encodeUsingBcryptPasswordEncoder(request.getPassword()));
        newUser.setUid(customUtils.generateToken());
        newUser.setCreatedAt(new Date());
        newUser.setRole(roleService.findByRoleName(AppConstants.USER_ROLE_STRING));
        return userRepo.save(newUser);
    }

    public User findByUsername(String username) throws InvalidUserException, Exception {
        User user = userRepo.findByUsername(username);
        if (user == null)
            throw new InvalidUserException("User does not exists");
        else
            return user;
    }

    public void createAdminUser(String adminUsername, String adminPassword, String adminEmail) throws Exception {
        if (userRepo.findByUsername(adminUsername) == null) {
            User adminUser = new User();
            Role role = roleService.findByRoleName(AppConstants.ADMIN_ROLE_STRING);
            adminUser.setUsername(adminUsername);
            adminUser.setEmail(adminEmail);
            adminUser.setPassword(customUtils.encodeUsingBcryptPasswordEncoder(adminPassword));
            adminUser.setUid(customUtils.generateToken());
            adminUser.setCreatedAt(new Date());
            adminUser.setRole(role);

            // new EntityManager().persist(adminUser);

            userRepo.save(adminUser);
        }
    }

    public List<User> getAllUsers() {
        try {
            return (List<User>) userRepo.findAll();
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
            return new ArrayList<>();
        }
    }

    public void deleteUserByUsername(String username) throws InvalidUserException, Exception {
        User user = userRepo.findByUsername(username);
        if (user == null)
            throw new InvalidUserException("User does not exists");
        else
            userRepo.delete(user);
    }
}
