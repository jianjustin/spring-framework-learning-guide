package org.janine.jian.service;

import org.janine.jian.domain.Role;
import org.janine.jian.domain.UserRole;
import org.janine.jian.repository.RoleRepository;
import org.janine.jian.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleService {
    @Autowired
    public UserRoleRepository userRoleRepository;

    public List<UserRole> getAllUserRoles() {
        List<UserRole> userRoles = new ArrayList<UserRole>();
        userRoleRepository.findAll().forEach(userRole -> userRoles.add(userRole));
        return userRoles;
    }
    public UserRole getUserRoleById(long id) {
        return userRoleRepository.findById(id).get();
    }
    public void saveOrUpdate(UserRole userRole) {
        userRoleRepository.save(userRole);
    }
    public void delete(long id) {
        userRoleRepository.deleteById(id);
    }
}
