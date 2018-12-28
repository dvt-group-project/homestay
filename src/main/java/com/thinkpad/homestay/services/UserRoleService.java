package com.thinkpad.homestay.services;

import com.thinkpad.homestay.models.UserRole;

import java.util.Optional;

public interface UserRoleService {
    Optional<UserRole> findById(Integer id);
}
