package com.app.licenta.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity(name = "ad_image")
@Table(name = "ad_image", schema = "public")
public class AdImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    @JdbcTypeCode(SqlTypes.BINARY)
    @Column(name = "image_data", columnDefinition = "bytea")
    private byte[] imageData;

    @OneToOne
    @JoinColumn(name = "ad_id")
    private Ad ad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }
}
