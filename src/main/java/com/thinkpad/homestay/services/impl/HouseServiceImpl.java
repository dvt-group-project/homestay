package com.thinkpad.homestay.services.impl;

import com.thinkpad.homestay.models.House;
import com.thinkpad.homestay.models.User;
import com.thinkpad.homestay.repository.HouseRepository;
import com.thinkpad.homestay.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseRepository houseRepository;

    @Override
    public Optional<House> findById(Integer id) {
        return houseRepository.findById(id);
    }

    @Override
    public Page<House> findAll(Pageable pageable) {
        return houseRepository.findAll(pageable);
    }

    @Override
    public void save(House house) {
        houseRepository.save(house);
    }

    @Override
    public void delete(Integer id) {
        houseRepository.deleteById(id);
    }

    @Override
    public Iterable<House> findAll() {
        return houseRepository.findAll();
    }

    @Override
    public Page<House> findAllByAddress(String address, Pageable pageable) {
        return houseRepository.findAllByAddress(address,pageable);
    }

    @Override
    public Iterable<String> findDistinctByAddress() {
        return houseRepository.findDistinctByAddress();
    }

    @Override
    public Page<House> findAllByUser(Pageable pageable, User user) {
        return houseRepository.findAllByUser(pageable, user);
    }
}
