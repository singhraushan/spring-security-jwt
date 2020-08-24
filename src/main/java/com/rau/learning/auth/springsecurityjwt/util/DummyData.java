package com.rau.learning.auth.springsecurityjwt.util;

import com.rau.learning.auth.springsecurityjwt.model.PersonDetails;
import com.rau.learning.auth.springsecurityjwt.model.Role;
import com.rau.learning.auth.springsecurityjwt.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DummyData {

    public static List<UserPersonWrapper> createUserPersonDetails() {
        List<UserPersonWrapper> list = new ArrayList<>();

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setEmail("admin@email.com");
        admin.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));
        PersonDetails adminPersonDetails = new PersonDetails();
        adminPersonDetails.setUsername(admin.getUsername());
        adminPersonDetails.setPersonName("Mike");
        adminPersonDetails.setContact("80556154");
        adminPersonDetails.setDob(LocalDate.of(1990, 3, 15));
        list.add(new UserPersonWrapper(admin, adminPersonDetails));

        User client = new User();
        client.setUsername("client");
        client.setPassword("client");
        client.setEmail("client@email.com");
        client.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_CLIENT)));
        PersonDetails clientPersonDetails = new PersonDetails();
        clientPersonDetails.setUsername(client.getUsername());
        clientPersonDetails.setPersonName("Federic");
        clientPersonDetails.setLastUpdated(LocalDateTime.now());
        clientPersonDetails.setContact("985652");
        clientPersonDetails.setDob(LocalDate.of(1991, 10, 21));
        list.add(new UserPersonWrapper(client, clientPersonDetails));

        return list;
    }
}
