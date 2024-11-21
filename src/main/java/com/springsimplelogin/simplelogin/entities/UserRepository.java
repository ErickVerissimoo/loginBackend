package com.springsimplelogin.simplelogin.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
User findByEmail(String email);
User findByPassword(String password);
}
