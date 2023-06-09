package com.example.jpabasics.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "t_clinic")
public class Clinic extends BaseEntity{
    private String name;

    //OneToMany ve ManyToMany ilişkilerdeki tip tanımları kesinlikle interface olmalı
    @OneToMany //Eğer join table kullanmazsan birleşim tablosunu kendisi default olarak yaratıyor, kullanmak istemezsem @JoinColumn ile bu entity üzerinden yönetmeliyim
    @JoinTable(name = "t_clinic_owner",joinColumns =@JoinColumn(name = "clinic_id"),inverseJoinColumns = @JoinColumn(name = "owner_id"))
    private Set<Owner> owners =new HashSet<>();

    @OneToMany
    @JoinTable(name="t_clinic_vet",joinColumns = @JoinColumn(name = "clinic_id"),inverseJoinColumns = @JoinColumn(name = "vet_id"))
    private Set<Vet> vets=new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Owner> getOwners() {
        return owners;
    }

    public void setOwners(Set<Owner> owners) {
        this.owners = owners;
    }

    public Set<Vet> getVets() {
        return vets;
    }

    public void setVets(Set<Vet> vets) {
        this.vets = vets;
    }
}
