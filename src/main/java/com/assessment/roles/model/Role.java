package com.assessment.roles.model;


import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "roles")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRole")
    private Integer idRole;
    @Column
    private String name;

    public Role() {
    }

    public Role(Integer idRole, String name) {
        this.idRole = idRole;
        this.name = name;
    }

    public Role(Integer idRole) {
        this.idRole = idRole;
    }

    public Role(String name){
        this.name = name;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
