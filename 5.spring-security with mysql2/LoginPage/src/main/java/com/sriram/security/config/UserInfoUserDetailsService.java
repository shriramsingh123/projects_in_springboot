package com.sriram.security.config;

import com.sriram.security.entities.UserInfo;
import com.sriram.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo=userRepository.findByUserName(username);

        return userInfo.map(UserInfoUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("User Not Found"));

    }
}
