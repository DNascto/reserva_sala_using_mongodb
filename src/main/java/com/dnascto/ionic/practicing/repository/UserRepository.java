package com.dnascto.ionic.practicing.repository;

import com.dnascto.ionic.practicing.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface UserRepository extends MongoRepository<Users, BigInteger> {
}
