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
        return hotelRepository.findById(id);
    }

    @Override
    public Hotel createHotel(HotelPojo hotelPojo) {
        // Ensure all required fields are provided
        if (hotelPojo.getHotelName() == null || hotelPojo.getHotelAddress() == null ||
                hotelPojo.getHotelCity() == null || hotelPojo.getPhoneNumber() == null ||
                hotelPojo.getHotelEmail() == null) {
            throw new IllegalArgumentException("All fields must be provided.");
        }

        Hotel hotel = new Hotel();
        hotel.setHotelName(hotelPojo.getHotelName());
        hotel.setAddress(hotelPojo.getHotelAddress());
        hotel.setCity(hotelPojo.getHotelCity());
        hotel.setPhoneNumber(Long.parseLong(hotelPojo.getPhoneNumber()));
        hotel.setEmail(hotelPojo.getHotelEmail());

        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotel(HotelPojo hotelPojo, Integer id) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        if (optionalHotel.isPresent()) {
            Hotel hotel = optionalHotel.get();
            // Ensure updated fields are provided
            if (hotelPojo.getHotelName() != null) hotel.setHotelName(hotelPojo.getHotelName());
            if (hotelPojo.getHotelAddress() != null) hotel.setAddress(hotelPojo.getHotelAddress());
            if (hotelPojo.getHotelCity() != null) hotel.setCity(hotelPojo.getHotelCity());
            if (hotelPojo.getPhoneNumber() != null) hotel.setPhoneNumber(Long.parseLong(hotelPojo.getPhoneNumber()));
            if (hotelPojo.getHotelEmail() != null) hotel.setEmail(hotelPojo.getHotelEmail());

            return hotelRepository.save(hotel);
        }
        throw new IllegalArgumentException("Hotel with id " + id + " not found.");
    }

    @Override
    public void deleteHotel(Integer id) {
        if (!hotelRepository.existsById(id)) {
            throw new IllegalArgumentException("Hotel with id " + id + " not found.");
        }
        hotelRepository.deleteById(id);
    }
}
