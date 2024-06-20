package com.example.hotelbooking.service.Impl;

import com.example.hotelbooking.entity.Hotel;
import com.example.hotelbooking.pojo.HotelPojo;
import com.example.hotelbooking.repository.HotelRepository;
import com.example.hotelbooking.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HotelImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Optional<Hotel> getHotelById(Integer id) {
//        Optional<Hotel> optionalHotel = ;
        return hotelRepository.findById(id);
    }

    @Override
    public Hotel createHotel(HotelPojo hotelPojo) {
        Hotel hotel = new Hotel();
        hotel.setHotelName(hotelPojo.getHotelName());
        hotel.setEmail(hotelPojo.getHotelEmail());
        hotel.setPassword(hotelPojo.getPassword());
        hotel.setAddress(hotelPojo.getHotelAddress());
        hotel.setCity(hotelPojo.getHotelCity());
        hotel.setPhoneNumber(hotelPojo.getPhoneNumber());

        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotel(HotelPojo hotelPojo, Integer id) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        if (optionalHotel.isPresent()) {
            Hotel hotel = optionalHotel.get();
            hotel.setHotelName(hotelPojo.getHotelName());
            hotel.setAddress(hotelPojo.getHotelAddress());
            hotel.setPassword(hotelPojo.getPassword());
            hotel.setCity(hotelPojo.getHotelCity());
            hotel.setPhoneNumber(hotelPojo.getPhoneNumber());


            return hotelRepository.save(hotel);
        }
        return null;
    }

    @Override
    public void deleteHotel(Integer id) {
        hotelRepository.deleteById(id);
    }
}
