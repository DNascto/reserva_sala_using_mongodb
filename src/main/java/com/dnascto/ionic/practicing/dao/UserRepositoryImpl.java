package com.dnascto.ionic.practicing.dao;

import com.dnascto.ionic.practicing.model.User;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl {
    @Autowired
    private UserRepository repository;

    private MongoTemplate mongoTemplate;

    @Autowired
    public UserRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public User findById(int id) {
        return repository.findById(id).get();
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public User login(String loginName, String password) {
        Query query = new Query(Criteria.where("password").is(password).orOperator(Criteria.where("cpf").is(loginName),Criteria.where("nickname").is(loginName)));
        return mongoTemplate.findOne(query,User.class);
    }

    public User login(String loginName) {
        Query query = new Query(Criteria.where("").orOperator(Criteria.where("cpf").is(loginName),Criteria.where("nickname").is(loginName)));
        return mongoTemplate.findOne(query,User.class);
    }

    public long editUser(User user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update();
        update.set("cpf", user.getCpf());
        update.set("password", user.getPassword());
        update.set("accessLevel", user.getAccessLevel());
        update.set("immediatlyApprovation", user.getImmediatlyApprovation());
        update.set("name", user.getName());
        update.set("nickname", user.getNickname());
//        update.set("", user.);

        UpdateResult result = mongoTemplate.updateFirst(query, update, User.class);

        if (result != null)
            return result.getModifiedCount();
        else
            return 0;
    }
}
