package com.example.jpabasics.model;

import jakarta.persistence.Embeddable;
import org.hibernate.annotations.Parent;

@Embeddable
public class Email {
    private String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
