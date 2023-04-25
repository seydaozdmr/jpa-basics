package com.example.jpabasics.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_image")
public class Image extends BaseEntity{
    @Column(name = "file_path")
    private String filePath;
    @Column(name = "height")
    private int height;
    @Column(name = "width")
    private int width;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @OneToOne(mappedBy = "image")
    private ImageContent imageContent;


    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public ImageContent getImageContent() {
        return imageContent;
    }

    public void setImageContent(ImageContent imageContent) {
        this.imageContent = imageContent;
    }
}
