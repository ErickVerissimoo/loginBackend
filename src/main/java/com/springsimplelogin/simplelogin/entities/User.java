package com.springsimplelogin.simplelogin.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Table(name = "user")
public class User {
    @Id
    @JsonIgnore
    private Integer id;
    private String email;
    private String password;

}
