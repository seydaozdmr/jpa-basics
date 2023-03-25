package com.example.jpabasics.model;

public enum CityCode {
    ANTALYA(7),İZMİR(35),İSTANBUL(34),ANKARA(6);

    private int value;

    private CityCode(int code){
        this.value=code;
    }

    public int getValue(){
        return value;
    }
}
