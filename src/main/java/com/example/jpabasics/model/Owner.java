package com.example.jpabasics.model;

import com.example.jpabasics.converter.RatingConverter;
import jakarta.persistence.*;

@Entity
@Table(name = "t_owner")
public class Owner  extends BaseEntity{

    @Column(name = "t_name")
    private String name;

    @Column(name="t_last_name")
    private String lastName;

    @Column(name = "t_rating")
    @Convert(converter = RatingConverter.class) //hibernate'e özel
    private Rating rating;

    @Embedded
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
