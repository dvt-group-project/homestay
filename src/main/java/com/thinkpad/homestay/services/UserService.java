package com.thinkpad.homestay.services;


import com.thinkpad.homestay.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {
    Page<User> findAll(Pageable pageable);

    void save(User user);

    void delete(Integer id);

    Optional<User> findById(Integer id);

    User findByName(String username);
}
