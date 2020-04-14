package com.dnascto.ionic.practicing.service;

import com.dnascto.ionic.practicing.model.Room;
import com.dnascto.ionic.practicing.repository.RoomRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class RoomService {
    @Autowired
    private RoomRepositoryImpl roomRepositoryImpl;

    public Room getRoom(BigInteger id){
        return roomRepositoryImpl.findById(id);
    }

    public List<Room> getAllRoom(){
        return roomRepositoryImpl.getAllRoom();
    }

    public List<Room> getAllFreeRoom(boolean booked){
        return roomRepositoryImpl.getAllRoomsByBooked(booked);
    }

    public Long getCountRoom(Boolean booked){
        return roomRepositoryImpl.getCountBookedRoom(booked);
    }

    public Room newRoom(Room room){
        return roomRepositoryImpl.addRoom(room);
    }

    public Room updateRoom(Room room){
        return roomRepositoryImpl.updateRoom(room);
    }

}
