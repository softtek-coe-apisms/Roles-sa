package com.assessment.roles.dao;

import com.assessment.roles.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Integer> {
}
