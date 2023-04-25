package com.example.jpabasics.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "t_pet")
public class Pet extends BaseEntity {

    @Column(name = "p_name")
    private String name;

//    @Column(name="p_type")
//    private String petType;
    //hiç bişey yazmazsan timestamp olarak db'de map ediliyor
    @Column(name="p_birt_date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime birtdate;

    @ManyToOne
    @JoinColumn(name="type_id")
    private PetType petType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(mappedBy = "pet") //çift yönlü bag ilişkisi (elemanların sırası rastgele alınır db'den)
    //@JoinColumn(name = "pet_id")
    private Collection<Visit> visits=new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "pet_id")
    @OrderColumn(name="pet_vaccine") //eklenen elemanların ekleme sırasına göre gelmesi için
    private List<PetVaccine> petVaccines;

    @OneToMany(mappedBy = "pet")
    @MapKey(name = "filePath")
    //@JoinColumn(name = "pet_id")
    private Map<String,Image> imagesByFilePath = new HashMap<>();

    @OneToOne(mappedBy = "pet") //çift yönlü onetoone
    private PetChip petChip;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBirtdate() {
        return birtdate;
    }

    public void setBirtdate(LocalDateTime birtdate) {
        this.birtdate = birtdate;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
