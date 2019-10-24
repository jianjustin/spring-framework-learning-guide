package org.janine.jian.controller;

import org.janine.jian.domain.RoleAuthority;
import org.janine.jian.service.RoleAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleAuthorityController {
    @Autowired
    public RoleAuthorityService roleAuthorityService;

    @GetMapping("/roleAuthorities")
    public List<RoleAuthority> getAllRoleAuthorities() {
        return roleAuthorityService.getAllRoleAuthorities();
    }

    @GetMapping("/roleAuthorities/{id}")
    public RoleAuthority getRoleAuthority(@PathVariable("id") long id) {
        return roleAuthorityService.getRoleAuthorityById(id);
    }

    @DeleteMapping("/roleAuthorities/{id}")
    public void deleteRoleAuthority(@PathVariable("id") long id) {
        roleAuthorityService.delete(id);
    }

    @PostMapping("/roleAuthorities")
    public long saveRoleAuthority(@RequestBody RoleAuthority roleAuthority) {
        roleAuthorityService.saveOrUpdate(roleAuthority);
        return roleAuthority.id;
    }
}
