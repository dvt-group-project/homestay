package com.thinkpad.homestay.services.impl;

import com.thinkpad.homestay.models.ImageHouse;
import com.thinkpad.homestay.repository.ImageHouseRepository;
import com.thinkpad.homestay.services.ImageHouseService;
import org.springframework.beans.factory.annotation.Autowired;

public class ImageHouseServiceImpl implements ImageHouseService {

    @Autowired
    private ImageHouseRepository imageHouseRepository;
    @Override
    public void save(ImageHouse imageHouse) {
        imageHouseRepository.save(imageHouse);
    }

    @Override
    public Iterable<ImageHouse> findAll(Integer house_id) {
        return imageHouseRepository.findAllByHouse_Id(house_id);
    }
}
