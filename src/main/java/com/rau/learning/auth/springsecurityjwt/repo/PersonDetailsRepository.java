package com.rau.learning.auth.springsecurityjwt.repo;

import com.rau.learning.auth.springsecurityjwt.model.PersonDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface PersonDetailsRepository  extends JpaRepository<PersonDetails, String> {

    PersonDetails findByUsername(String username);

    void deleteByUsername(String username);

}