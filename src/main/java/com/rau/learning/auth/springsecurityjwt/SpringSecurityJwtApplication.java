package com.rau.learning.auth.springsecurityjwt;

import com.rau.learning.auth.springsecurityjwt.service.UserService;
import com.rau.learning.auth.springsecurityjwt.util.DummyData;
import com.rau.learning.auth.springsecurityjwt.util.UserPersonWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringSecurityJwtApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtApplication.class, args);
    }

    @Override
    public void run(String... params) throws Exception {//this get call when call SpringApplication.run if you passJwtAuthServiceApp.class
        List<UserPersonWrapper> data = DummyData.createUserPersonDetails();
        for (UserPersonWrapper temp : data) {
            userService.signup(temp.getUser(), temp.getPersonDetails());
        }
    }
}
