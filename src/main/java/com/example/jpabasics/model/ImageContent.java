package com.example.jpabasics.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_image_content")
public class ImageContent{
    @Id
    private Long id;
    @OneToOne
    @MapsId
    private Image image;

    @Lob
    private byte[] content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
