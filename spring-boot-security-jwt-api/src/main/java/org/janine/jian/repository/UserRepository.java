package org.janine.jian.repository;

import org.janine.jian.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    public User findByMemberUserName(String memberUserName);
}
