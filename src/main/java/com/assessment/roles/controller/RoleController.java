package com.assessment.roles.controller;


import com.assessment.roles.model.Role;
import com.assessment.roles.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



import java.util.Map;


@Controller
@RequestMapping(path = "/roles")
public class RoleController {


    @Autowired
    private RoleService roleService;

    @GetMapping
    public @ResponseBody Iterable<Role> getAllRoles(){
        return roleService.getRoles();
    }

    @PostMapping
    public @ResponseBody Role addRole(@RequestBody Map<String,Object> role){
        return  roleService.saveRole(role);
    }
    @DeleteMapping(value = "/{roleId}")
    public @ResponseBody String deleteRole(@PathVariable("roleId") String roleId){
       return roleService.deleteRole(roleId);
    }

    @PutMapping
    public  @ResponseBody String updateRole(@RequestBody Role role){
        return  roleService.updateRole(role);
    }
}
