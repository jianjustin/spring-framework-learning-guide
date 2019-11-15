package org.janine.jian.service;

import org.janine.jian.domain.Authority;
import org.janine.jian.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorityService {
    @Autowired
    public AuthorityRepository authorityRepository;

    public List<Authority> getAllAuthorities() {
        List<Authority> authorities = new ArrayList<Authority>();
        authorityRepository.findAll().forEach(authority -> authorities.add(authority));
        return authorities;
    }
    public Authority getAuthorityById(long id) {
        return authorityRepository.findById(id).get();
    }
    public void saveOrUpdate(Authority authority) {
        authorityRepository.save(authority);
    }
    public void delete(long id) {
        authorityRepository.deleteById(id);
    }
}
