package com.thinkpad.homestay.repository;


import com.thinkpad.homestay.models.ImageHouse;
import org.springframework.data.repository.CrudRepository;

public interface ImageHouseRepository extends CrudRepository<ImageHouse, Integer> {
    Iterable<ImageHouse> findAllByHouse_Id(Integer integer);
}
