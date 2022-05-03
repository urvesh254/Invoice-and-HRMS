package com.itaims.ihs.service;

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals(USERNAME)) {
            return new User(USERNAME, PASSWORD, new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User Not Found!");
        }
    }
}
