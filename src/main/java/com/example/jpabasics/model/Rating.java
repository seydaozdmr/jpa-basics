package com.example.jpabasics.model;

public enum Rating {
    STANDART(100),PREMIUM(500);
    private int value;
    private Rating(int value){
        this.value=value;
    }
    public int getValue(){
        return this.value;
    }
}
