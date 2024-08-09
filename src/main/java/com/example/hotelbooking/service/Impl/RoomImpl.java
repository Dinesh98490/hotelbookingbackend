package com.example.hotelbooking.service.Impl;

import com.example.hotelbooking.entity.Hotel;
import com.example.hotelbooking.entity.Room;
import com.example.hotelbooking.pojo.RoomPojo;
import com.example.hotelbooking.repository.HotelRepository;
import com.example.hotelbooking.repository.RoomRepository;
import com.example.hotelbooking.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoomImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomById(Integer id) {
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public Room createRoom(RoomPojo roomPojo) {
        Room room = new Room();
        room.setId(roomPojo.getId());
//        room.setRoomNumber(roomPojo.getRoomNumber());
        room.setRoomfloor(roomPojo.getRoomNumber());
        room.setRoomtype(roomPojo.getRoomType());
        room.setPricepernight(roomPojo.getPricePerNight());
        room.setAvailabilitystatus(roomPojo.getAvailabilityStatus());
        Optional<Hotel> optionalHotel = hotelRepository.findById(roomPojo.getHotelId());
        if (optionalHotel.isPresent()) {
            Hotel hotel = optionalHotel.get();
            room.setHotel(hotel);
        } else {
            // Handle the case where the hotel is not found
            throw new RuntimeException("Hotel not found with id: " + roomPojo.getHotelId());
        }

        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(RoomPojo roomPojo, Integer id) {
        Optional<Room> roomOptional = roomRepository.findById(id);
        if (roomOptional.isPresent()) {
            Room room = roomOptional.get();

            room.setRoomfloor(roomPojo.getRoomNumber());
//            room.setRoomNumber(roomPojo.getRoomNumber());
            room.setRoomtype(roomPojo.getRoomType());
            room.setPricepernight(roomPojo.getPricePerNight());
            room.setAvailabilitystatus(roomPojo.getAvailabilityStatus());
            Optional<Hotel> optionalHotel = hotelRepository.findById(roomPojo.getHotelId());
            if (optionalHotel.isPresent()) {
                Hotel hotel = optionalHotel.get();
                room.setHotel(hotel);
            }



            return roomRepository.save(room);
        }
        return null;
    }

    @Override
    public void deleteRoom(Integer id) {
        roomRepository.deleteById(id);
    }
}