package com.springsimplelogin.simplelogin;

import org.springframework.web.bind.annotation.RestController;

import com.springsimplelogin.simplelogin.entities.User;
import com.springsimplelogin.simplelogin.entities.UserRepository;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class restMain {
    @Autowired
    private UserRepository repo;
    @Autowired private serviceUser service;
    @PostMapping("/cadastro")
    public String cadastrar(@RequestBody User user) {
        User usuario = new User();
        usuario.setEmail(user.getEmail());
    
        usuario.setPassword(user.getPassword());
        repo.save(usuario);
        return "Usuario cadastrado";
    }
    @PostMapping("/login")
    public ResponseEntity<Void> login(HttpSession sessao, @RequestBody User user, HttpServletResponse response) {
        if(service.exists(user)){
            Cookie cook = new Cookie("sessionid", sessao.getId());
            cook.setHttpOnly(true);
            response.addCookie(cook);    
            return ResponseEntity.ok().build();
        }
  return ResponseEntity.notFound().build();
    }
  
    
}
