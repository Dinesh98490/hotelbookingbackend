package com.example.hotelbooking.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BookingPojo {
    private Integer id;
    private String gender;
    private String nationality;
    private String firstname;
    private String lastname;
    private String address;
    private int customerId;
    private int roomId;

}





