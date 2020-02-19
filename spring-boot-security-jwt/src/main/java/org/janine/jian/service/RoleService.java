package org.janine.jian.service;

import org.janine.jian.domain.Role;
import org.janine.jian.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    public RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        List<Role> roles = new ArrayList<Role>();
        roleRepository.findAll().forEach(role -> roles.add(role));
        return roles;
    }
    public Role getRoleById(long id) {
        return roleRepository.findById(id).get();
    }
    public void saveOrUpdate(Role role) {
        roleRepository.save(role);
    }
    public void delete(long id) {
        roleRepository.deleteById(id);
    }
}
