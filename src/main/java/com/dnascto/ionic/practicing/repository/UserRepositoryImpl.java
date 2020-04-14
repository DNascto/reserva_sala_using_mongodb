package com.dnascto.ionic.practicing.repository;

import com.dnascto.ionic.practicing.model.Users;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class UserRepositoryImpl {
    @Autowired
    private UserRepository repository;

    private MongoTemplate mongoTemplate;

    @Autowired
    public UserRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Users createUser(Users users) {
        return repository.save(users);
    }

    public Users findById(BigInteger id) {
        return repository.findById(id).get();
    }

    public Users findByNickname(String nickname, String company) {
        Query query = new Query(Criteria.where("nickname").is(nickname).and("company").in(company));
        return mongoTemplate.findOne(query, Users.class);
    }

    public Users findByCpf(String cpf, String company) {
        Query query = new Query(Criteria.where("cpf").is(cpf).and("company").in(company));
        return mongoTemplate.findOne(query, Users.class);
    }

    public Users login(String loginName, String password) {
        Query query = new Query(Criteria.where("password").is(password).orOperator(Criteria.where("cpf").is(loginName),Criteria.where("nickname").is(loginName)));
        return mongoTemplate.findOne(query, Users.class);
    }

    public Users login(String loginName) {
        Query query = new Query(Criteria.where("").orOperator(Criteria.where("cpf").is(loginName),Criteria.where("nickname").is(loginName)));
        return mongoTemplate.findOne(query, Users.class);
    }

    public long editUser(Users users) {
        Query query = new Query(Criteria.where("id").is(users.getId()));
        Update update = new Update();
        update.set("cpf", users.getCpf());
        update.set("password", users.getPassword());
        update.set("accessLevel", users.getAccessLevel());
        update.set("immediatlyApprovation", users.getImmediatlyApprovation());
        update.set("name", users.getName());
        update.set("nickname", users.getNickname());
//        update.set("", user.);

        UpdateResult result = mongoTemplate.updateFirst(query, update, Users.class);

        if (result != null)
            return result.getModifiedCount();
        else
            return 0;
    }
}
