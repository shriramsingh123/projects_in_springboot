package com.sriram.security.services;

import com.sriram.security.entities.UserInfo;

import java.util.List;

public interface UserService {
    UserInfo registerUser(UserInfo userInfo);

    List<UserInfo> getAllUser();

    UserInfo getUserById(Long id);
}
