package com.example.jpabasics.model;

import com.example.jpabasics.converter.CityCodeUserType;
import jakarta.persistence.*;
//import org.hibernate.annotations.Type;
//import org.hibernate.annotations.TypeDef;

//@TypeDef(name = "cityCode",typeClass = CityCodeUserType.class)
@Embeddable
public class Address {

    @Column( name = "t_phone_type")
    @Enumerated(EnumType.STRING)
    private PhoneType phoneType;

    @Column(name = "t_street")
    private String street;

    @Column( name = "t_phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "city_id",foreignKey = @ForeignKey(name="fk_adress_city"))
    private City city;

    //@Type(value = CityCodeUserType.class)
    private CityCode cityCode;

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CityCode getCityCode() {
        return cityCode;
    }

    public void setCityCode(CityCode cityCode) {
        this.cityCode = cityCode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
