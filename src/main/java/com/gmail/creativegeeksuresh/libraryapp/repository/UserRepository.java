package com.gmail.creativegeeksuresh.libraryapp.repository;

import java.util.List;

import com.gmail.creativegeeksuresh.libraryapp.model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByUid(String uid);

    public User findByUsername(String username);

    public User findByEmail(String email);

    public List<User> findByUsernameOrEmail(String username, String email);

    // public void deleteUserByUsername(String username);

}
