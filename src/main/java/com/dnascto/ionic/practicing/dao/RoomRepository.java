package com.dnascto.ionic.practicing.dao;

import com.dnascto.ionic.practicing.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends MongoRepository<Room, Integer> {
////    @Query("SELECT r FROM Room r WHERE r.name = :name")
//    @Query("{name: name}")
//    List<Room> findByName(@Param("name") String name);
//
////    @Query("SELECT COUNT(r) FROM Room r WHERE r.booked = :book")
//    @Query("{booked: booked}")
//    Long countByBooked(@Param("book") Boolean booked);
//
////    @Query("SELECT r FROM Room r ")//WHERE r.booked = false")
//    @Query("{booked: false}")
//    List<Room> findNoBookedRooms();
}
