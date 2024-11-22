package com.springsimplelogin.simplelogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.Session;
import org.springframework.session.jdbc.JdbcIndexedSessionRepository;
import org.springframework.stereotype.Service;

import com.springsimplelogin.simplelogin.entities.User;

@Service
public class SessionService  {
    @Autowired
    private JdbcIndexedSessionRepository sessao;
    @Autowired 
    private serviceUser service;
    public void associateUser(User usuario) throws Exception{
        Session session = sessao.createSession();
        
        service.addSession(session.getId(), usuario.getId());
        
    }
}
