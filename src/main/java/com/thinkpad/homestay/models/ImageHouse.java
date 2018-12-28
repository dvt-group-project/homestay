package com.thinkpad.homestay.models;

import javax.persistence.*;

@Entity
@Table(name = "images_house")
public class ImageHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer avatar;
    private String url;

    @ManyToOne
    @JoinColumn(name = "house_id")
    public House house;

    public ImageHouse() {
    }

    public ImageHouse(String url,House house,Integer avatar) {
        this.url = url;
        this.house = house;
        this.avatar = avatar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAvatar() {
        return avatar;
    }

    public void setAvatar(Integer avatar) {
        this.avatar = avatar;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
