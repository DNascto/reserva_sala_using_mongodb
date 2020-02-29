package com.dnascto.ionic.practicing.controller;

import com.dnascto.ionic.practicing.model.Room;
import com.dnascto.ionic.practicing.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:8100")
public class RoomController {
    @Autowired
    private RoomService service;

    public RoomController() {}

    public RoomController(RoomService service) {
        this.service = service;
    }

    @GetMapping("/room")
    public Room getRoom(@RequestParam int id){
        return service.getRoom(id);
    }

    @GetMapping("/rooms")
    public ResponseEntity<List<Room>> getAllFreeRooms(@RequestParam Boolean booked){
        return ResponseEntity.ok(service.getAllFreeRoom(booked));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.ok(service.getAllRoom());
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCountRooms(@RequestParam Boolean booked) {
        return ResponseEntity.ok(service.getCountRoom(booked));
    }

    @PostMapping("/room")
    public Room postNewRoom(@RequestBody Room room){
        return service.newRoom(room);
    }

}
