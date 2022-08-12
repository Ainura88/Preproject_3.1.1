package net.proselyte.springbootdemo.controller;


import net.proselyte.springbootdemo.model.User;
import net.proselyte.springbootdemo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private  final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userServiceImpl.getUsers();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/new")
    public String createUserForm(User user) {
        return "addUser";
    }

    @PostMapping("/new")
    public String createUser(User user) {
    userServiceImpl.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userServiceImpl.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/editUser/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        User user = userServiceImpl.getUser(id);
        model.addAttribute("user", user);
        return "/editUser";
    }

    @PostMapping("/editUser")
    public String updateUser(User user) {
        userServiceImpl.addUser(user);
        return "redirect:/users";
    }
}

