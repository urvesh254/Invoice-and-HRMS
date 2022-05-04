package com.itaims.ihs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final String USERNAME = "Urvesh";
    private final String PASSWORD = "urvesh@123";

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.itaims.ihs.entity.User givenUserDetails = userService.getByEmail(username);

        if (givenUserDetails != null) {
            return new User(givenUserDetails.getEmail(), givenUserDetails.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not Found!!");
        }
    }
}
