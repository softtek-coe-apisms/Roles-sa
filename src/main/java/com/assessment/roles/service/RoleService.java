package com.assessment.roles.service;

import com.assessment.roles.model.Role;
import com.assessment.roles.repository.RoleRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Log
@Service
public class RoleService implements IRolesService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role saveRole(Map<String,Object> role) {
        Role newRole = new Role(role.get("name").toString());
        roleRepository.save(newRole);
        log.info("New Role added");
        return newRole;
    }

    @Override
    public Iterable<Role> getRoles() {
        log.info("Find all roles");
        return roleRepository.findAll();
    }

    @Override
    public String deleteRole(String roleId) {
        if(roleRepository.existsById(Integer.parseInt(roleId))){
            roleRepository.deleteById(Integer.parseInt(roleId));
            log.info("Role  with id: "+ roleId+" deleted");
            return "Role deleted successfully";
        }else{
            log.severe("Role cannot be deleted");

            return "Role could not be deleted ";
        }
    }

    @Override
    public String updateRole(Role role) {
        roleRepository.save(role);
        System.out.println("Role updated");
        log.info("Role with id: "+ role.getIdRole()+" updated");
        return "Role updated successfully";
    }
}
