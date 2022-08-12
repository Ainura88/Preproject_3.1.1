package net.proselyte.springbootdemo.service;

import net.proselyte.springbootdemo.model.User;

import java.util.List;

public interface UserService {

    User getUser(Long id);

    List<User> getUsers();

    User addUser(User user);

    void deleteUser(Long id);
}
