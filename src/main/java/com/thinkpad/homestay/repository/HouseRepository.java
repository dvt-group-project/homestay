package com.thinkpad.homestay.repository;


import com.thinkpad.homestay.models.House;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HouseRepository extends PagingAndSortingRepository<House, Integer> {

}
