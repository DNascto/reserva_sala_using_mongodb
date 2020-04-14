package com.dnascto.ionic.practicing.repository;

import com.dnascto.ionic.practicing.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface BookingRepository extends MongoRepository<Booking, BigInteger> {
//    @Query("SELECT b FROM Booking b WHERE b.approved = :app and b.date >= :day")
//    @Query("{approved: app}")
//    List<Booking> findByApproved(@Param("app") Boolean approved, @Param("day") LocalDateTime day);

//    @Query("SELECT b FROM Booking b WHERE b.author = :name")
    @Query("{author: 'name'}")
    List<Booking> findByAuthor(@Param("name") String authorName);
}
