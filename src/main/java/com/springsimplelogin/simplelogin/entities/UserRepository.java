package com.springsimplelogin.simplelogin.entities;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
User findByEmail(String email);
User findByPassword(String password);
@Transactional
@Modifying
@Query("UPDATE user SET session_id = :session_id WHERE id = :id")
void addSession(@Param("session_id") String session_id, @Param("id") Integer id);
}
