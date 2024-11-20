package com.springsimplelogin.simplelogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsimplelogin.simplelogin.entities.User;
import com.springsimplelogin.simplelogin.entities.UserRepository;

@Service
public class serviceUser {
@Autowired
private UserRepository repo;

public boolean exists(User usuario){
    if(repo.findByEmail(usuario.getEmail())!=null && repo.findByPassword(usuario.getPassword())!=null){
return true;
    }
    return false;
}
}
