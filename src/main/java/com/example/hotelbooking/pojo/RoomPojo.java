package com.example.hotelbooking.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RoomPojo {
    private Integer id;
    private int roomNumber;
    private String roomType;
    private int pricePerNight;
    private String availabilityStatus;
    private int hotelId;
}
