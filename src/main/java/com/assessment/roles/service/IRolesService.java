package com.assessment.roles.service;

import com.assessment.roles.model.Role;

import java.util.Map;

public interface IRolesService {
    Role saveRole(Map<String,Object> role);
    Iterable<Role> getRoles();
    String deleteRole(String idRole);
    String updateRole(Role role);
}
