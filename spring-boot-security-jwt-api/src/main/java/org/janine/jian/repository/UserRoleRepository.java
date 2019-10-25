package org.janine.jian.repository;

import org.janine.jian.domain.UserRole;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRoleRepository extends CrudRepository<UserRole,Long> {
    List<UserRole> findByMemberUserId(long memberUserId);
}
