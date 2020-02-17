package com.dnascto.ionic.practicing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class User {
    @Id
    private Integer id;
    private String name;
    private String nickname;
    private String cpf;
    private String password;
//    private String group; //empresa a qual pertence
    private Integer accessLevel; //gerencia, comum, presidente, admin
    private Boolean immediatlyApprovation;
}
