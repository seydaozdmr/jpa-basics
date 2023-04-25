package com.example.jpabasics.model;

import com.example.jpabasics.converter.RatingConverter;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_owner")
public class Owner  extends BaseEntity{

    @Column(name = "t_name")
    private String name;

    @Column(name="t_last_name")
    private String lastName;

    @Column(name = "t_rating")
    @Convert(converter = RatingConverter.class) //hibernate'e özel
    private Rating rating;

    @ElementCollection
    @CollectionTable(name = "owner_emails")
    private Set<String> emails=new HashSet<>();
    @Embedded
    private Address address;
    /**
     * Eğer sadece OneToMany ile ilişki kurulursa joinTable default olarak araya yeni bir tablo kurar
     * Bunu explicitly yani açıkça @JoinTable annotasyonu ile kurabiliriz.
     * Eğer Owner ile Pet arasında çift yönlü bir ilişki kurulmak istenirse ve her iki tarafta'da @JoinColumn annotasyonları
     * kullanılmış ise hibernate çalışma zamanında bu iki tablo arasındaki ilişkiyi ayrı ayrı ele alıyor.
     * Gereksiz işlemler (update) yapıyor. Bunu için ilişkinin bir tarafında bunun belirtilmesi gerekiyor.
     * mappedBy attribute'u bu işi gerçekleştirmek için kullanılıyor ve hedef entitydeki alanın adını alması gerekiyor.
     * İki entity arasındaki ilişkiyi yönetme noktasında hibernate collection'a bakmaz yani ilişkinin bu tarafındaki Set'e bakmaz
     * diğer taraftaki owner'a bakar. (@JoinColumn da kaldırılmalı)
     */
    @OneToMany(mappedBy = "owner",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    //@JoinColumn(name = "owner_id") //tek yönlü foreignKey üzerinden OneToMany ilişkisi (pet tablosunda bu alan yaratılır:owner_id
    private Set<Pet> pets = new HashSet<>();




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

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public Set<String> getEmails() {
        return emails;
    }

    public void setEmails(Set<String> emails) {
        this.emails = emails;
    }
}
