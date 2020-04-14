package com.dnascto.ionic.practicing.security;

import com.dnascto.ionic.practicing.model.Users;
import com.dnascto.ionic.practicing.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<Users> loginOptional = loginRepository.login(email);
//        Users users = loginOptional.orElseThrow(() -> new UsernameNotFoundException("E-mail e/ou senha incorretos"));
        Users users = userRepository.login(email);
        if(users == null)
            new UsernameNotFoundException("E-mail e/ou senha incorretos");

//        return new UserSystem(users, getPermissions(users));
        return new UserSystem(users, new HashSet<>());
    }

    private Collection<? extends GrantedAuthority> getPermissions(Users users) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        users.getPermissions().forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getDescription().toUpperCase())));

        return authorities;
    }
}
