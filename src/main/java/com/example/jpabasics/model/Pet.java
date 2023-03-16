package com.example.jpabasics.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "t_pet")
public class Pet extends BaseEntity {

    @Column(name = "p_name")
    private String name;

    @Column(name="p_type")
    private String petType;
    //hiç bişey yazmazsan timestamp olarak db'de map ediliyor
    @Column(name="p_birt_date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime birtdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public LocalDateTime getBirtdate() {
        return birtdate;
    }

    public void setBirtdate(LocalDateTime birtdate) {
        this.birtdate = birtdate;
    }
}
