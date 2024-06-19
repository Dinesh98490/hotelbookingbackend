package com.example.hotelbooking.controller;


import com.example.hotelbooking.entity.Hotel;
import com.example.hotelbooking.pojo.HotelPojo;
import com.example.hotelbooking.service.HotelService;
import com.example.hotelbooking.shared.pojo.GlobalApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hotels")
@AllArgsConstructor
public class HotelController {
    private final HotelService hotelService;
    @GetMapping
    public ResponseEntity<GlobalApiResponse<List<Hotel>>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        GlobalApiResponse<List<Hotel>> globalApiResponse = new GlobalApiResponse<>("data  retrived successfully",200,hotels);
        return ResponseEntity.ok(globalApiResponse);
    }
    @GetMapping("/id")
    public ResponseEntity<GlobalApiResponse<Hotel>> getHotelById(@RequestParam Integer id) {
         Hotel hotels = hotelService.getHotelById(id);
        GlobalApiResponse<Hotel> globalApiResponse = new GlobalApiResponse<>("data reterived successfully",200,hotels);
        return ResponseEntity.ok(globalApiResponse);
    }

    @PostMapping
    public ResponseEntity<GlobalApiResponse<Hotel>> createHotel(@RequestBody HotelPojo hotel) {
        Hotel hotels = hotelService.createHotel(hotel);
        GlobalApiResponse<Hotel> globalApiResponse = new GlobalApiResponse<>("data created sucessfully",201,hotels);
        return ResponseEntity.ok(globalApiResponse);


    }
    @DeleteMapping
    public ResponseEntity<GlobalApiResponse<Void>> deleteHotel(@RequestParam Integer id) {
        hotelService.deleteHotel(id);
        GlobalApiResponse<Void> globalApiResponse = new GlobalApiResponse<>("data deleted sucessfully",201,null);
        return ResponseEntity.ok(globalApiResponse);

    }

    @PutMapping
    public ResponseEntity<GlobalApiResponse<Hotel>> updateHotel(@RequestBody HotelPojo hotel) {
        Hotel hotels = hotelService.updateHotel(hotel);
        GlobalApiResponse<Hotel> globalApiResponse = new GlobalApiResponse<>("data updated successfully",201,hotels);
        return ResponseEntity.ok(globalApiResponse);

    }

}
