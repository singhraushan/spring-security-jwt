package com.rau.learning.auth.springsecurityjwt.util;

import com.rau.learning.auth.springsecurityjwt.model.PersonDetails;
import com.rau.learning.auth.springsecurityjwt.model.User;

public class UserPersonWrapper {
    private User user;
    private PersonDetails personDetails;

    public UserPersonWrapper(User user, PersonDetails personDetails) {
        this.user = user;
        this.personDetails = personDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PersonDetails getPersonDetails() {
        return personDetails;
    }

    public void setPersonDetails(PersonDetails personDetails) {
        this.personDetails = personDetails;
    }
}
