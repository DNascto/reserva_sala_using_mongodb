package com.dnascto.ionic.practicing.dao;

import com.dnascto.ionic.practicing.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class BookingRepositoryImpl {
    @Autowired
    private BookingRepository repository;

    private MongoTemplate mongoTemplate;

    @Autowired
    public BookingRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Booking findById(int id){
        return repository.findById(id).get();
    }

    public List<Booking> getAllBookings(){
        return repository.findAll();
    }

    public List<Booking> findByApprove(Boolean approved){
        Query query = new Query(Criteria.where("approved").is(approved).and("date").gte( LocalDateTime.now().minusHours(1)));
        return mongoTemplate.find(query, Booking.class);
    }

    public List<Booking> findByAuthor(String authorName){
        Query query = new Query(Criteria.where("author").is(authorName));
        return mongoTemplate.find(query, Booking.class);
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
