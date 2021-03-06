package org.janine.jian.controller;

import org.janine.jian.domain.UserRole;
import org.janine.jian.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = "user")
public class UserRoleController {
    @Autowired
    public UserRoleService userRoleService;

    @GetMapping("/userRoles")
    @PreAuthorize("hasAuthority('UserRole.getAllUserRoles')")
    public List<UserRole> getAllUserRoles() {
        return userRoleService.getAllUserRoles();
    }

    @GetMapping("/userRoles/{id}")
    @PreAuthorize("hasAuthority('UserRole.getUserRole')")
    public UserRole getUserRole(@PathVariable("id") long id) {
        return userRoleService.getUserRoleById(id);
    }

    @DeleteMapping("/userRoles/{id}")
    @PreAuthorize("hasAuthority('UserRole.deleteUserRoles')")
    public void deleteUserRoles(@PathVariable("id") long id) {
        userRoleService.delete(id);
    }

    @PostMapping("/userRoles")
    @PreAuthorize("hasAuthority('UserRole.saveUserRoles')")
    public long saveUserRoles(@RequestBody UserRole userRole) {
        userRoleService.saveOrUpdate(userRole);
        return userRole.id;
    }
}
