package com.thinkpad.homestay.repository;


import com.thinkpad.homestay.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
    User findUserByName(String name);
}
