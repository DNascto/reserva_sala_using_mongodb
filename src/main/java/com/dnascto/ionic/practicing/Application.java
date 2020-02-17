package com.dnascto.ionic.practicing;

import com.dnascto.ionic.practicing.dao.*;
import com.dnascto.ionic.practicing.model.Room;
import com.dnascto.ionic.practicing.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

//@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    RoomRepository repository;

    @Autowired
    RoomRepositoryImpl roomRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        deleteAll();
        addSampleData();
        listAll();
        roomRepository.updateRoom(new Room(1, "Sala Grande", 44, true, false));
        roomRepository.getAllRoom();
        System.out.println("Find by Id: " + roomRepository.findById(1));
        System.out.println("Count booking: " + roomRepository.getCountBookedRoom(true));
        System.out.println("Count free   : " + roomRepository.getCountBookedRoom(false));
        System.out.println("Bookings false: " + roomRepository.getAllRoomsByBooked(false));
        System.out.println("Bookings true: " + roomRepository.getAllRoomsByBooked(true));
    }

    public void deleteAll() {
        System.out.println("Deleting all records..");
        repository.deleteAll();
    }

    public void addSampleData() {
        System.out.println("Adding sample data");
        roomRepository.addRoom(new Room(1, "Sala Pequena", 10, false, false));
        repository.save(new Room(4, "Sala Media", 25, true, false));
    }

    public void listAll() {
        System.out.println("Listing sample data");
        repository.findAll().forEach(u -> System.out.println(u));
    }

//        bookingRepo.save(new Booking(1, LocalDateTime.now(), roomList.get(3), 60, "Linux Mouse", false));
////        userRepository.save(new User(1, "Daniel Rodrigues", "d","09876543211", "d","TCS", 4, true));
////        userRepository.save(new User(3, "Daniel Nascimento", "n","09876543212", "n","TCS", 1, true));
//        userRepo.save(new User(1, "Daniel Rodrigues", "d","09876543211", "d",4, false));
//        userRepo.save(new User(3, "Daniel Nascimento", "a","09876543212", "a", 1, true));

}
