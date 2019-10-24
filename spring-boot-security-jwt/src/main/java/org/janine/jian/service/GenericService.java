package org.janine.jian.service;

import org.janine.jian.domain.RandomCity;
import org.janine.jian.domain.User;

import java.util.List;

public interface GenericService {
    User findByUsername(String username);
    List<User> findAllUsers();
    List<RandomCity> findAllRandomCities();
}
