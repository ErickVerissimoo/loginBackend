package com.springsimplelogin.simplelogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springsimplelogin.simplelogin.entities.User;
import com.springsimplelogin.simplelogin.entities.UserRepository;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
public class restMain {
    @Autowired
    private UserRepository repo;
    @Autowired private serviceUser service;
    @Autowired private SessionService session;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody User user){
        try{
        service.add(user);
        return ResponseEntity.ok("Usuario cadastrado");
    }
        catch(Exception e){
            System.out.println("erro: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

        
    }
    @PostMapping("/login")
    public ResponseEntity<String> postMethodName(@RequestBody User user, HttpSession sessao, 
    HttpServletResponse response) throws Exception {
        if(service.exists(user)){
            Cookie cook = new Cookie("sessionID", sessao.getId());
            cook.setHttpOnly(true);
            cook.setPath("/");
            response.addCookie(cook);
        
            session.associateUser(    repo.findByEmail(user.getEmail()));
            return ResponseEntity.ok("Usuario autenticado");
        }
        
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("/getcook")
    public String getMethodName(@CookieValue(name = "sessionID") String cookie) {
    
        return "O nome do cookie é: " + cookie;
    }
    
    
}
