package com.example.jpabasics.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_vet")
public class Vet extends BaseEntity {

    @Column(name = "t_name")
    private String name;

    @Column(name="t_last_name")
    private String lastName;

    @Column(name = "works_full_time")
    private Boolean worksFullTime;
    @ManyToMany
    @JoinTable(name = "t_vet_speciality",joinColumns = @JoinColumn(name = "vet_id"),inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities;


    @ElementCollection
    @CollectionTable(name = "t_vet_emails",joinColumns = @JoinColumn(name = "vet_id"))
    private Set<Email> emails=new HashSet<>();


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

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }

    public Boolean getWorksFullTime() {
        return worksFullTime;
    }

    public void setWorksFullTime(Boolean worksFullTime) {
        this.worksFullTime = worksFullTime;
    }
}
