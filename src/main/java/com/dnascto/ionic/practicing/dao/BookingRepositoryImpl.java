package com.dnascto.ionic.practicing.dao;

import com.dnascto.ionic.practicing.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class BookingRepositoryImpl {
    @Autowired
    private BookingRepository repository;

    public Booking findById(int id){
        return repository.findById(id).get();
//        return bookingRepository.getOne(String.valueOf(id));
    }

    public List<Booking> getAllBookings(){
        return repository.findAll();
    }

    public List<Booking> findByApprove(Boolean approved){
        return repository.findByApproved(approved, LocalDateTime.now());
    }

    public List<Booking> findByAuthor(String authorName){
        return repository.findByAuthor(authorName);
    }

    public Booking addBooking(Booking booking){
        return repository.save(booking);
    }

    public Booking updateBooking(Booking booking) {
        return repository.save(booking);
    }

    public void deleteBooking(Booking booking) {
        repository.delete(booking);
    }
}
