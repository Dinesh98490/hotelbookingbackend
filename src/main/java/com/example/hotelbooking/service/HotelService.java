package com.example.hotelbooking.service;

import com.example.hotelbooking.entity.Hotel;
import com.example.hotelbooking.pojo.HotelPojo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface HotelService {
    List<Hotel> getAllHotels();
    Optional<Hotel> getHotelById(Integer id);
    Hotel createHotel(HotelPojo hotelPojo);
    Hotel updateHotel(HotelPojo hotelPojo,Integer id);
    void deleteHotel(Integer id);

}
