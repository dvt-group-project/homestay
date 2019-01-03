package com.thinkpad.homestay.repository;


import com.thinkpad.homestay.models.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface HouseRepository extends PagingAndSortingRepository<House, Integer> {

    Page<House> findAllByAddress(String address, Pageable pageable);

    @Query("select distinct address from House ")
    Iterable<String> findDistinctByAddress();
}
