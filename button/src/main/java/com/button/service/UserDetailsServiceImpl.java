package com.button.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User.UserBuilder builder = null;

        if (s.equals("user")) {
            builder = User.withUsername(s);
            builder.password(new BCryptPasswordEncoder().encode("user"));
            builder.roles("USER");
        } else {
            throw new UsernameNotFoundException("User not found");
        }

        return builder.build();
    }
}
