package com.example.jpabasics.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_clinic")
public class Clinic extends BaseEntity{
    private String name;

    @OneToMany //Eğer join table kullanmazsan birleşim tablosunu kendisi default olarak yaratıyor, kullanmak istemezsem @JoinColumn ile bu entity üzerinden yönetmeliyim
    @JoinTable(name = "t_clinic_owner",joinColumns =@JoinColumn(name = "clinic_id"),inverseJoinColumns = @JoinColumn(name = "owner_id"))
    private Set<Owner> owners =new HashSet<>();

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
}
