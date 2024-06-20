package com.example.hotelbooking.controller;


import com.example.hotelbooking.entity.Room;
import com.example.hotelbooking.pojo.RoomPojo;
import com.example.hotelbooking.service.RoomService;
import com.example.hotelbooking.shared.pojo.GlobalApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("room")
@AllArgsConstructor
public class RoomController {
    private final RoomService roomService;
    @GetMapping
    public ResponseEntity<GlobalApiResponse<List<Room>>> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        GlobalApiResponse<List<Room>> globalApiResponse = new GlobalApiResponse<>("data retrived successfully",  200, rooms);
        return ResponseEntity.ok(globalApiResponse);

    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Room>> getRoomById(@PathVariable Integer id) {
        Room rooms = roomService.getRoomById(id);
        GlobalApiResponse<Room>  globalApiResponse = new GlobalApiResponse<>("data retrived successfully",  200, rooms);
        return ResponseEntity.ok(globalApiResponse);
    }
    @PostMapping
    public ResponseEntity<GlobalApiResponse<Room>> createRoom(@RequestBody RoomPojo room) {
      Room rooms = roomService.createRoom(room);
        GlobalApiResponse<Room>  globalApiResponse = new GlobalApiResponse<>("data created successfully",  201, rooms);
        return ResponseEntity.ok(globalApiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Void>> deleteRoom(@PathVariable Integer id) {
        roomService.deleteRoom(id);
        GlobalApiResponse<Void>  globalApiResponse = new GlobalApiResponse<>("data deleted successfully",  201, null);
        return ResponseEntity.ok(globalApiResponse);

    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Room>> updateRoom(@PathVariable RoomPojo room, @PathVariable Integer id) {
        Room rooms = roomService.updateRoom(room,id);
        GlobalApiResponse<Room>  globalApiResponse = new GlobalApiResponse<>("data updated successfully",  201, rooms);
        return ResponseEntity.ok(globalApiResponse);

    }

}
