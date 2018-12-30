package com.thinkpad.homestay.repository;


import com.thinkpad.homestay.models.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HouseRepository extends PagingAndSortingRepository<House, Integer> {

    Page<House> findAllByAddress(String address, Pageable pageable);

}
