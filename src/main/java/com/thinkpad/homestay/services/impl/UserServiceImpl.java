package com.thinkpad.homestay.services.impl;

import com.thinkpad.homestay.models.User;
import com.thinkpad.homestay.repository.UserRepository;
import com.thinkpad.homestay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByName(String username) {
        return userRepository.findUserByName(username);
    }
}
