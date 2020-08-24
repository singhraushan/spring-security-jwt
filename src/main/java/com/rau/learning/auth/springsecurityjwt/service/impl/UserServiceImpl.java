package com.rau.learning.auth.springsecurityjwt.service.impl;

import com.rau.learning.auth.springsecurityjwt.dto.RegistrationDto;
import com.rau.learning.auth.springsecurityjwt.exception.CustomException;
import com.rau.learning.auth.springsecurityjwt.model.PersonDetails;
import com.rau.learning.auth.springsecurityjwt.model.User;
import com.rau.learning.auth.springsecurityjwt.repo.PersonDetailsRepository;
import com.rau.learning.auth.springsecurityjwt.repo.UserRepository;
import com.rau.learning.auth.springsecurityjwt.service.UserService;
import com.rau.learning.auth.springsecurityjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PersonDetailsRepository personDetailsRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),user.getRoles());

        /*return org.springframework.security.core.userdetails.User//
                .withUsername(username)//
                .password(user.getPassword())//
                .authorities(user.getRoles())//
                .accountExpired(false)//
                .accountLocked(false)//
                .credentialsExpired(false)//
                .disabled(false)//
                .build();*/
    }

    @Override
    public String login(String username, String password) {

        try {  //authentication
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (
                AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        //token creation
        return jwtUtil.createToken(username, userRepository.findByUsername(username).getRoles());
    }

    @Transactional
    public String signup(User user, PersonDetails personDetails) {
        if (!userRepository.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            personDetails.setLastUpdated(LocalDateTime.now());
            personDetailsRepository.save(personDetails);
            return "Successfully registered";
        } else {
            throw new CustomException("Username is already in DB", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public String signup(RegistrationDto registrationDto) {
        return signup(modelMapper.map(registrationDto, User.class), modelMapper.map(registrationDto, PersonDetails.class));
    }
}
