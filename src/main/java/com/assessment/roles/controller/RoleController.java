package com.assessment.roles.controller;

import com.assessment.roles.dao.RoleRepository;
import com.assessment.roles.model.Role;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Map;


@Controller
@RequestMapping(path = "/roles")
public class RoleController {

    Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping
    public @ResponseBody Iterable<Role> getAllRoles(){
        log.info("Find all roles");
        return roleRepository.findAll();
    }

    @PostMapping
    public @ResponseBody Role addRole(@RequestBody Map<String,Object> role){
        Role newRole = new Role(role.get("name").toString());
        roleRepository.save(newRole);
        log.info("New Role added");
        return newRole;
    }
    @DeleteMapping(value = "/{roleId}")
    public @ResponseBody String deleteRole(@PathVariable("roleId") String roleId){
        if(roleRepository.existsById(Integer.parseInt(roleId))){
            roleRepository.deleteById(Integer.parseInt(roleId));
            log.info("Role  with id: "+ roleId+" deleted");
            return "Role deleted successfully";
        }else{
            log.error("Role cannot be deleted");
            return "Role could not be deleted ";
        }
    }

    @PutMapping
    public  @ResponseBody String updateRole(@RequestBody Role role){
        roleRepository.save(role);
        System.out.println("Role updated");
        log.info("Role with id: "+ role.getIdRole()+" updated");
        return "Role updated successfully";
    }
}
