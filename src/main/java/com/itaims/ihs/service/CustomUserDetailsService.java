package com.itaims.ihs.service;

import com.itaims.ihs.entity.User;
import com.itaims.ihs.util.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final String USERNAME = "Urvesh";
    private final String PASSWORD = "urvesh@123";

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User givenUserDetails = userService.getByEmail(username);

        if (givenUserDetails != null) {
            return new MyUserDetails(givenUserDetails);
        } else {
            throw new UsernameNotFoundException("User not Found!!");
        }
    }
}
