package org.janine.jian.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private static List<UserDetails> users = new ArrayList<>();

    public MyUserDetailsService() {
        users.add(
                User.withDefaultPasswordEncoder()
                        .username("root")
                        .password("root")
                        .roles("ADMIN")
                        .build());
        users.add(
                User.withDefaultPasswordEncoder()
                        .username("jian")
                        .password("123456")
                        .roles("MEMBER")
                        .build());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDetails> userDetails = users.stream().filter(u->u.getUsername().equals(username)).findAny();
        if (!userDetails.isPresent())
            throw new UsernameNotFoundException("User not found by name: " + username);
        return userDetails.get();
    }
}
