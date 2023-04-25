package com.example.jpabasics.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "t_visit")
public class Visit extends BaseEntity{
    @Column(name = "visit_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date visitDate;

    @Lob
    @Column(name = "visit_description")
    private String visitDescription;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;


    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getVisitDescription() {
        return visitDescription;
    }

    public void setVisitDescription(String visitDescription) {
        this.visitDescription = visitDescription;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
