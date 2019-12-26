package com.button.service;

import com.button.model.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        com.button.model.entity.User user = userRepository.findUserByLogin(s);

        User.UserBuilder builder = null;

        if (user != null) {
            builder = User.withUsername(user.getLogin());
            builder.password(new BCryptPasswordEncoder().encode(user.getPass()));
            builder.roles("USER");
        } else {
            throw new UsernameNotFoundException("User not found");
        }

        return builder.build();
    }
}
