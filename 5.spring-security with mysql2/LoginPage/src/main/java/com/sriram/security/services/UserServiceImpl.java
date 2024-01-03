package com.sriram.security.services;

import com.sriram.security.entities.UserInfo;
import com.sriram.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserInfo registerUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
               return userRepository.save(userInfo);

    }

    @Override
    public List<UserInfo> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public UserInfo getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException("User Not Found"));
    }
}
