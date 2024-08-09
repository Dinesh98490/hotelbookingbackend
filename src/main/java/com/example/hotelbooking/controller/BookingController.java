package com.example.hotelbooking.controller;

import com.example.hotelbooking.entity.Booking;
import com.example.hotelbooking.pojo.BookingPojo;
import com.example.hotelbooking.service.BookingService;
import com.example.hotelbooking.shared.pojo.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;

    @GetMapping
    public ResponseEntity<GlobalApiResponse<List<Booking>>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        GlobalApiResponse<List<Booking>> globalApiResponse = new GlobalApiResponse<>("Data retrieved successfully", 200, bookings);
        return ResponseEntity.ok(globalApiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Booking>> getBookingById(@PathVariable Integer id) {
        Booking booking = bookingService.getBookingById(id);
        GlobalApiResponse<Booking> globalApiResponse = new GlobalApiResponse<>("Data retrieved successfully", 200, booking);
        return ResponseEntity.ok(globalApiResponse);
    }

    @PostMapping
    public ResponseEntity<GlobalApiResponse<Booking>> createBooking(@RequestBody BookingPojo bookingPojo) {
        Booking booking = bookingService.createBooking(bookingPojo);
        GlobalApiResponse<Booking> globalApiResponse = new GlobalApiResponse<>("Data created successfully", 200, booking);
        return ResponseEntity.ok(globalApiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Void>> deleteBooking(@PathVariable Integer id) {
        bookingService.deleteBooking(id);
        GlobalApiResponse<Void> globalApiResponse = new GlobalApiResponse<>("Data deleted successfully", 200, null);
        return ResponseEntity.ok(globalApiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Booking>> updateBooking(@PathVariable Integer id, @RequestBody BookingPojo bookingPojo) {
        Booking booking = bookingService.updateBooking(id, bookingPojo);
        GlobalApiResponse<Booking> globalApiResponse = new GlobalApiResponse<>("Data updated successfully", 200, booking);
        return ResponseEntity.ok(globalApiResponse);
    }
}
