package com.example.hotelbooking.controller;

import com.example.hotelbooking.entity.Hotel;
import com.example.hotelbooking.pojo.HotelPojo;
import com.example.hotelbooking.service.HotelService;
import com.example.hotelbooking.shared.pojo.GlobalApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
@AllArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @GetMapping
    public ResponseEntity<GlobalApiResponse<List<Hotel>>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        GlobalApiResponse<List<Hotel>> globalApiResponse = new GlobalApiResponse<>("Data retrieved successfully", 200, hotels);
        return ResponseEntity.ok(globalApiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Hotel>> getHotelById(@PathVariable Integer id) {
        Optional<Hotel> hotel = hotelService.getHotelById(id);
        if (hotel.isPresent()) {
            GlobalApiResponse<Hotel> globalApiResponse = new GlobalApiResponse<>("Data retrieved successfully", 200, hotel.get());
            return ResponseEntity.ok(globalApiResponse);
        } else {
            return ResponseEntity.status(404).body(new GlobalApiResponse<>("Hotel not found", 404, null));
        }
    }

    @PostMapping
    public ResponseEntity<GlobalApiResponse<Hotel>> createHotel(@RequestBody HotelPojo hotelPojo) {
        try {
            Hotel hotel = hotelService.createHotel(hotelPojo);
            GlobalApiResponse<Hotel> globalApiResponse = new GlobalApiResponse<>("Data created successfully", 201, hotel);
            return ResponseEntity.status(201).body(globalApiResponse);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new GlobalApiResponse<>(e.getMessage(), 400, null));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Void>> deleteHotel(@PathVariable Integer id) {
        try {
            hotelService.deleteHotel(id);
            GlobalApiResponse<Void> globalApiResponse = new GlobalApiResponse<>("Data deleted successfully", 200, null);
            return ResponseEntity.ok(globalApiResponse);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(new GlobalApiResponse<>(e.getMessage(), 404, null));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Hotel>> updateHotel(@RequestBody HotelPojo hotelPojo, @PathVariable Integer id) {
        try {
            Hotel hotel = hotelService.updateHotel(hotelPojo, id);
            GlobalApiResponse<Hotel> globalApiResponse = new GlobalApiResponse<>("Data updated successfully", 200, hotel);
            return ResponseEntity.ok(globalApiResponse);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(new GlobalApiResponse<>(e.getMessage(), 404, null));
        }
    }
}
