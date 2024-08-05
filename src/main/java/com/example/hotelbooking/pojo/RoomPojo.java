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
    private String roomNumber;
    private String roomType;
    private String pricePerNight;
    private String availabilityStatus;
    private Integer hotelId=1;
}
