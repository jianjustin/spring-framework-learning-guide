package org.janine.jian.controller;

import org.janine.jian.domain.Role;
import org.janine.jian.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = "role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/roles")
    @PreAuthorize("hasAuthority('Role.getAllRoles')")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/roles/{id}")
    @PreAuthorize("hasAuthority('Role.getRole')")
    public Role getRole(@PathVariable("id") long id) {
        return roleService.getRoleById(id);
    }

    @DeleteMapping("/roles/{id}")
    @PreAuthorize("hasAuthority('Role.deleteRole')")
    public void deleteRole(@PathVariable("id") long id) {
        roleService.delete(id);
    }

    @PostMapping("/roles")
    @PreAuthorize("hasAuthority('Role.saveRole')")
    public long saveRole(@RequestBody Role role) {
        roleService.saveOrUpdate(role);
        return role.id;
    }
}
