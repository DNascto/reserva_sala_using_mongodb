package com.dnascto.ionic.practicing;

import com.dnascto.ionic.practicing.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    BookingRepository repository;

//    @Autowired
//    BookingRepositoryImpl bookingRepository;

//    List<Room> roomList = Arrays.asList(new Room[]{new Room(1, "Sala Pequena", 10, false, false),
//            new Room(4, "Sala Media", 25, true, false)});

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        deleteAll();
//        addSampleData();
//        listAll();
    }

    public void deleteAll() {
        System.out.println("Deleting all records..");
        repository.deleteAll();
    }

//    public void addSampleData() {
//        System.out.println("Adding sample data");
//        bookingRepository.addBooking(new Booking(1, LocalDateTime.now(), roomList.get(0), 60, "Linux Mouse", false));
//        repository.save(new Booking(3, LocalDateTime.now(), roomList.get(1), 60, "Mark Gates", false));
//    }

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
