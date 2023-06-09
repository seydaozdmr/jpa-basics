package com.example.jpabasics.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="person_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Person extends BaseEntity {
    //mappedSuper class annotasyonu da TablePer Class gibi çalışır ama entity olarak tanımlanmdığı için entity ilişkilerinde kullanılmaz
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
