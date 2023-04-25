package com.example.jpabasics.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_speciality")
public class Speciality extends BaseEntity{
    private String name;

    @ManyToMany(mappedBy = "specialities") //çift yönlü ilişki
    private Set<Vet> vets=new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Vet> getVets() {
        return vets;
    }

    public void setVets(Set<Vet> vets) {
        this.vets = vets;
    }
}
