package com.dnascto.ionic.practicing.controller;

import com.dnascto.ionic.practicing.dto.DtoBooking;
import com.dnascto.ionic.practicing.model.Booking;
import com.dnascto.ionic.practicing.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@CrossOrigin(origins = {"https://dry-journey-31622.herokuapp.com", "http://localhost:8100"})
public class BookingController {
    private BookingService service;

    @Autowired
    public BookingController(BookingService service) {
        this.service = service;
    }

    @GetMapping("/booking")
    public ResponseEntity<Booking> getBooking(@RequestParam BigInteger id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(service.getAllBooking());
    }

    @GetMapping("/approve")
    public ResponseEntity<List<Booking>> findByApprove(@RequestParam Boolean approved) {
        return ResponseEntity.ok(service.findByApprove(approved));
    }

    @GetMapping("/author")
    public ResponseEntity<List<Booking>> findByAuthor(@RequestParam String authorName) {
        return ResponseEntity.ok(service.findByAuthor(authorName));
    }

    @PostMapping("/booking")
    public ResponseEntity<Booking> postBooking(@RequestBody DtoBooking dtoBooking) {
        return ResponseEntity.ok(service.newBooking(new Booking(dtoBooking)));
    }

    @PutMapping("/booking")
    public ResponseEntity<Booking> putBooking(@RequestBody Booking booking) {
        return ResponseEntity.ok(service.updateBooking(booking));
    }

    @DeleteMapping("/booking")
    public ResponseEntity<Booking> deleteBooking(@RequestBody Booking booking) {
        service.deleteBooking(booking);
        return ResponseEntity.ok().build();
    }

}
