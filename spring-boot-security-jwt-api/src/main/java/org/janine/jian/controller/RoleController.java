package org.janine.jian.controller;

import org.janine.jian.domain.Role;
import org.janine.jian.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/roles/{id}")
    public Role getRole(@PathVariable("id") long id) {
        return roleService.getRoleById(id);
    }

    @DeleteMapping("/roles/{id}")
    public void deleteRole(@PathVariable("id") long id) {
        roleService.delete(id);
    }

    @PostMapping("/roles")
    public long saveRole(@RequestBody Role role) {
        roleService.saveOrUpdate(role);
        return role.id;
    }
}
