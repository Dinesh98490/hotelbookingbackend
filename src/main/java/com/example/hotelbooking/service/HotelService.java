package com.example.hotelbooking.service;

import com.example.hotelbooking.entity.Hotel;
import com.example.hotelbooking.pojo.HotelPojo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HotelService {
    List<Hotel> getAllHotels();
    Hotel getHotelById(Integer id);
    Hotel createHotel(HotelPojo hotelPojo);
    Hotel updateHotel(HotelPojo hotelPojo);
    void deleteHotel(Integer id);

}
