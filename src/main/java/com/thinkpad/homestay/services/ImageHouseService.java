package com.thinkpad.homestay.services;


import com.thinkpad.homestay.models.ImageHouse;

public interface ImageHouseService {
    void save(ImageHouse imageHouse);

    Iterable<ImageHouse> findAll(Integer house_id);
}
