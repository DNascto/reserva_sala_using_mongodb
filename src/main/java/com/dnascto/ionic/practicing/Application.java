package com.dnascto.ionic.practicing;

import com.dnascto.ionic.practicing.dao.BookingRepository;
import com.dnascto.ionic.practicing.dao.RoomRepository;
import com.dnascto.ionic.practicing.dao.UserRepository;
import com.dnascto.ionic.practicing.dao.UserRepositoryImpl;
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
    UserRepository repository;

    @Autowired
    UserRepositoryImpl userRepositoryMain;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        deleteAll();
        addSampleData();
        listAll();
        userRepositoryMain.editUser(new User(1, "Juan Martinez", "j", "09876543211", "j", 3, false));
        listAll();
        System.out.println("Find by Id: " + userRepositoryMain.findById(1));
        System.out.println("Login: " + userRepositoryMain.login("09876543211", "j"));
    }

    public void deleteAll() {
        System.out.println("Deleting all records..");
        repository.deleteAll();
    }

    public void addSampleData() {
        System.out.println("Adding sample data");
        userRepositoryMain.createUser(new User(1, "Daniel Rodrigues", "d", "09876543211", "d", 4, false));
        repository.save(new User(3, "Eduardo Nascimento", "a", "09876543212", "a", 1, true));

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
