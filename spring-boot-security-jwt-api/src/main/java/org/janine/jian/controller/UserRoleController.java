package org.janine.jian.controller;

import org.janine.jian.domain.UserRole;
import org.janine.jian.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRoleController {
    @Autowired
    public UserRoleService userRoleService;

    @GetMapping("/userRoles")
    public List<UserRole> getAllUserRoles() {
        return userRoleService.getAllUserRoles();
    }

    @GetMapping("/userRoles/{id}")
    public UserRole getUserRole(@PathVariable("id") long id) {
        return userRoleService.getUserRoleById(id);
    }

    @DeleteMapping("/userRoles/{id}")
    public void deleteUserRoles(@PathVariable("id") long id) {
        userRoleService.delete(id);
    }

    @PostMapping("/userRoles")
    public long saveUserRoles(@RequestBody UserRole userRole) {
        userRoleService.saveOrUpdate(userRole);
        return userRole.id;
    }
}
