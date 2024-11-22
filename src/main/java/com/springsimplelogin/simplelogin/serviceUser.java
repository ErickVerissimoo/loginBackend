package com.springsimplelogin.simplelogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springsimplelogin.simplelogin.entities.User;
import com.springsimplelogin.simplelogin.entities.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class serviceUser {
  private class EntityAlreadyExistsException extends Exception{
        EntityAlreadyExistsException(String message){
            super(message);
        }
    }

@Autowired
private UserRepository repo;
@Autowired private HttpSession sessao;
public boolean exists(User usuario){
    if(repo.findByEmail(usuario.getEmail())!=null && repo.findByPassword(usuario.getPassword())!=null ){
return true;
    }
    return false;
}

public void add(User user) throws Exception {
    if (repo.findByEmail(user.getEmail()) != null) {
        throw new EntityAlreadyExistsException("Email já cadastrado.");
    }
    
    repo.save(user);
}
@Transactional
public void addSession(String sessionID, Integer id){
repo.addSession(sessionID, id);
}
}



