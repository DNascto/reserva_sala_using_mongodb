package com.dnascto.ionic.practicing.repository;

import com.dnascto.ionic.practicing.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class RoomRepositoryImpl {
    @Autowired
    private RoomRepository repository;

    private MongoTemplate mongoTemplate;

    @Autowired
    public RoomRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Room findById(BigInteger id){
        return repository.findById(id).get();
    }

    public List<Room> getAllRoom(){
        return repository.findAll();
    }

    public List<Room> getAllRoomsByBooked(boolean booked){
        Query query = new Query(Criteria.where("booked").is(booked));
        return mongoTemplate.find(query, Room.class);
    }

    public Long getCountBookedRoom(Boolean booked){
        Query query = new Query(Criteria.where("booked").is(booked));
        return mongoTemplate.count(query, Room.class);
    }

    public Room addRoom(Room room){
        return repository.save(room);
    }

    public Room updateRoom(Room room){
        return repository.save(room);
    }

}
