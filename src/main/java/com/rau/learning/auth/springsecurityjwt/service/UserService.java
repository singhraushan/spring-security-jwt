package com.rau.learning.auth.springsecurityjwt.service;

import com.rau.learning.auth.springsecurityjwt.dto.RegistrationDto;
import com.rau.learning.auth.springsecurityjwt.model.PersonDetails;
import com.rau.learning.auth.springsecurityjwt.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public String login(String username, String password);
    public String signup(RegistrationDto registrationDto);
    public String signup(User user, PersonDetails personDetails);

}
