package com.rau.learning.auth.springsecurityjwt.repo;

import javax.transaction.Transactional;

import com.rau.learning.auth.springsecurityjwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

  boolean existsByUsername(String username);

  User findByUsername(String username);

  void deleteByUsername(String username);

}