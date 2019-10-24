package org.janine.jian.controller;

import org.janine.jian.domain.Authority;
import org.janine.jian.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorityController {
    @Autowired
    AuthorityService authorityService;
    @GetMapping("/authoritiess")
    public List<Authority> getAllAuthorities() {
        return authorityService.getAllAuthorities();
    }

    @GetMapping("/authoritiess/{id}")
    public Authority getAuthority(@PathVariable("id") long id) {
        return authorityService.getAuthorityById(id);
    }

    @DeleteMapping("/authoritiess/{id}")
    public void deleteAuthority(@PathVariable("id") long id) {
        authorityService.delete(id);
    }

    @PostMapping("/authoritiess")
    public long saveAuthority(@RequestBody Authority authority) {
        authorityService.saveOrUpdate(authority);
        return authority.id;
    }
}
