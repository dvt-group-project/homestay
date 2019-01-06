package com.thinkpad.homestay.services;


import com.thinkpad.homestay.models.House;
import com.thinkpad.homestay.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface HouseService {
    Optional<House> findById(Integer id);

    Page<House> findAll(Pageable pageable);

    void save(House house);

    void delete(Integer id);

    Iterable<House> findAll();

    Page<House> findAllByAddress(String address, Pageable pageable);

    Iterable<String> findDistinctByAddress();

    Page<House> findAllByUser(Pageable pageable, User user);
}
