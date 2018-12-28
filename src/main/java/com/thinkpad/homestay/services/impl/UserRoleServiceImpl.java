package com.thinkpad.homestay.services.impl;

import com.thinkpad.homestay.models.UserRole;
import com.thinkpad.homestay.repository.UserRoleRepository;
import com.thinkpad.homestay.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;


    @Override
    public Optional<UserRole> findById(Integer id) {
        return userRoleRepository.findById(id);
    }
}
