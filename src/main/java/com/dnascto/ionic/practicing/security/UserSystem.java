package com.dnascto.ionic.practicing.security;

import com.dnascto.ionic.practicing.model.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserSystem extends User {

    private static final long serialVersionUID = 1L;

    private Users users;

    public UserSystem(Users users, Collection<? extends GrantedAuthority> authorities) {
        super(users.getCpf(), users.getPassword(), authorities);
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }
}
