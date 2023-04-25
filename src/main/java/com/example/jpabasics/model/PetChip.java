package com.example.jpabasics.model;

import jakarta.persistence.*;

@Entity
@Table
public class PetChip extends BaseEntity {

    @Column(name = "chip_code")
    private Long chipCode;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;


    public Long getChipCode() {
        return chipCode;
    }

    public void setChipCode(Long chipCode) {
        this.chipCode = chipCode;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
