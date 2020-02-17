package com.dnascto.ionic.practicing.dto;

import com.dnascto.ionic.practicing.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DtoUserWithToken {
    private User user;
    private String token;
//
//    public ResponseUserWithToken(User user, String token) {
//        this.user = user;
//        this.token = token;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public String getToken() {
//        return token;
//    }
//
//    public void setToken(String token) {
//        this.token = token;
//    }

}
