package com.dnascto.ionic.practicing.service;

import com.dnascto.ionic.practicing.exceptions.DuplicateException;
import com.dnascto.ionic.practicing.model.Users;
import com.dnascto.ionic.practicing.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class UserService {
    @Autowired
    private UserRepositoryImpl userRepository;
    @Autowired(required = false)
    private BCryptPasswordEncoder encoder;

    public Users findById(BigInteger id) {
        return userRepository.findById(id);
    }

    public String getCompanyName(BigInteger id) {
        Users user = userRepository.findById(id);
        return user.getCompany();
    }

    public Users createUser(Users user) {
        if (userRepository.findByNickname(user.getNickname(), user.getCompany()) != null) {
            throw new DuplicateException("Nickname já cadastrado.");
        }

        if (userRepository.findByCpf(user.getCpf(), user.getCompany()) != null) {
            throw new DuplicateException("CPF já cadastrado.");
        }

        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.createUser(user);
    }

    public Users login(String loginName, String password) {
        return userRepository.login(loginName, password);
    }

    public Users login(String loginName) {
        return userRepository.login(loginName);
    }

    public Long editUser(Users users) {
        return userRepository.editUser(users);
    }
}
