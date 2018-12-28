package com.thinkpad.homestay.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    public UserRole() {
    }

    public UserRole(String name) {
        this.name = name;
    }

    @OneToMany(targetEntity = User.class,mappedBy = "userRole")
    private Collection<User> users;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}

