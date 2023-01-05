package com.hrsystem.userapi.services;


import com.hrsystem.userapi.domain.User;

import java.util.List;


public interface UserService {
    User findById(Long id);
    List<User> findAll();
}
