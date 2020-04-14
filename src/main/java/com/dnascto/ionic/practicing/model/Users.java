package com.dnascto.ionic.practicing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class Users {
    @Id
    private BigInteger id;
    private String name;
    private String nickname;
    private String cpf;
    private String password;
    private String company;
    private Integer accessLevel; //gerencia, comum, presidente, admin
    private Boolean immediatlyApprovation;
    private Set<Permission> permissions;
}
