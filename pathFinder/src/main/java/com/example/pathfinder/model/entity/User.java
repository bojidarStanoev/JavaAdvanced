package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.LevelEnum;

import javax.persistence.*;
import java.util.Set;

@Entity(name="users")
public class User extends BaseEntity{
    @Column( nullable = false)
    private String fullname;
    @Column
    private String username;
    @Column(nullable = true)
    private String password;
    @Column
    private String email;
    @Column
    private Integer age;
    @Enumerated(EnumType.STRING)
    private LevelEnum level;
    @ManyToMany
    private Set<Role> roles;

    public User() {
    }

    public String fullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String password() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer age() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LevelEnum level() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
    }

    public Set<Role> roles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
