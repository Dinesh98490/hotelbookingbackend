package com.example.hotelbooking.service;

import com.example.hotelbooking.entity.Room;
import com.example.hotelbooking.pojo.RoomPojo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RoomService {
    List<Room> getAllRooms();
    Room getRoomById(Integer id);
    Room createRoom(RoomPojo roomPojo);
    Room updateRoom(RoomPojo roomPojo, Integer id);
    void deleteRoom(Integer id);
}
