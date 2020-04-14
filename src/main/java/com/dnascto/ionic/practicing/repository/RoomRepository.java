package com.dnascto.ionic.practicing.repository;

import com.dnascto.ionic.practicing.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface RoomRepository extends MongoRepository<Room, BigInteger> {
}
