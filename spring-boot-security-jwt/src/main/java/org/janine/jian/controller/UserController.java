package org.janine.jian.controller;

import org.janine.jian.domain.User;
import org.janine.jian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = "user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('User.getAllUsers')")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    @PreAuthorize("hasAuthority('User.getUser')")
    public User getUser(@PathVariable("id") long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/users/{id}")
    @PreAuthorize("hasAuthority('User.deleteUser')")
    public void deleteUser(@PathVariable("id") long id) {
        userService.delete(id);
    }

    @PostMapping("/users")
    @PreAuthorize("hasAuthority('User.saveUser')")
    public long saveUser(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return user.id;
    }
}
