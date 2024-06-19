package com.example.hotelbooking.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelPojo {
    private  Integer hotelId;
    private  String hotelName;
    private  String password;
    private  String hotelAddress;
    private  String hotelCity;
    private  String hotelEmail;
    private int  phoneNumber;



}
