package com.hrsystem.userapi.services.impl;

import com.hrsystem.userapi.domain.User;
import com.hrsystem.userapi.repository.UserRepository;
import com.hrsystem.userapi.services.UserService;
import com.hrsystem.userapi.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found."));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
