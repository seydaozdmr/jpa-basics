package com.example.jpabasics.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "t_pet_vaccine")
public class PetVaccine extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "vaccine_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vaccineDate;

    @ManyToOne
    @JoinColumn(name = "pet_id",insertable = false,updatable = false)
    private Pet pet;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getVaccineDate() {
        return vaccineDate;
    }

    public void setVaccineDate(Date vaccineDate) {
        this.vaccineDate = vaccineDate;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
