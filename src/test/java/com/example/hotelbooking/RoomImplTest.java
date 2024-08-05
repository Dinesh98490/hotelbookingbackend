package com.example.hotelbooking;

import com.example.hotelbooking.entity.Hotel;
import com.example.hotelbooking.entity.Room;
import com.example.hotelbooking.pojo.RoomPojo;
import com.example.hotelbooking.repository.HotelRepository;
import com.example.hotelbooking.repository.RoomRepository;
import com.example.hotelbooking.service.Impl.RoomImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RoomImplTest {

    @Mock
    private RoomRepository roomRepository;

    @Mock
    private HotelRepository hotelRepository;

    @InjectMocks
    private RoomImpl roomImpl;

    @Test
    public void testGetAllRooms() {
        Room room1 = new Room();
        Room room2 = new Room();
        when(roomRepository.findAll()).thenReturn(Arrays.asList(room1, room2));

        assertEquals(2, roomImpl.getAllRooms().size());
    }

    @Test
    public void testGetRoomById() {
        Room room = new Room();
        when(roomRepository.findById(anyInt())).thenReturn(Optional.of(room));

        Room result = roomImpl.getRoomById(1);
        assertNotNull(result);
        assertEquals(room, result);
    }

    @Test
    public void testGetRoomByIdNotFound() {
        when(roomRepository.findById(anyInt())).thenReturn(Optional.empty());

        Room result = roomImpl.getRoomById(1);
        assertNull(result);
    }

    @Test
    public void testCreateRoom() {
        RoomPojo roomPojo = new RoomPojo();
        roomPojo.setId(1);
        roomPojo.setRoomNumber("101");
        roomPojo.setRoomType("Deluxe");
        roomPojo.setPricePerNight(String.valueOf(150.0));
        roomPojo.setAvailabilityStatus("Available");
        roomPojo.setHotelId(1);

        Hotel hotel = new Hotel();
        when(hotelRepository.findById(anyInt())).thenReturn(Optional.of(hotel));

        Room room = new Room();
        when(roomRepository.save(any(Room.class))).thenReturn(room);

        Room createdRoom = roomImpl.createRoom(roomPojo);
        assertNotNull(createdRoom);
        verify(roomRepository, times(1)).save(any(Room.class));
    }

    @Test
    public void testCreateRoomHotelNotFound() {
        RoomPojo roomPojo = new RoomPojo();
        roomPojo.setId(1);
        roomPojo.setRoomNumber("101");
        roomPojo.setRoomType("Deluxe");
        roomPojo.setPricePerNight(String.valueOf(150.0));
        roomPojo.setAvailabilityStatus("Available");
        roomPojo.setHotelId(1);

        when(hotelRepository.findById(anyInt())).thenReturn(Optional.empty());

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            roomImpl.createRoom(roomPojo);
        });
        assertEquals("Hotel not found with id: 1", thrown.getMessage());
    }



    @Test
    public void testUpdateRoomNotFound() {
        RoomPojo roomPojo = new RoomPojo();
        roomPojo.setId(1);

        when(roomRepository.findById(anyInt())).thenReturn(Optional.empty());

        Room updatedRoom = roomImpl.updateRoom(roomPojo, 1);
        assertNull(updatedRoom);
    }

    @Test
    public void testDeleteRoom() {
        roomImpl.deleteRoom(1);
        verify(roomRepository, times(1)).deleteById(1);
    }
}

