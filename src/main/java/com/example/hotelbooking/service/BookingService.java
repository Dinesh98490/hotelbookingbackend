package com.example.hotelbooking.service;

import com.example.hotelbooking.Projection.BookingProj;
import com.example.hotelbooking.entity.Booking;
import com.example.hotelbooking.pojo.BookingPojo;

import java.util.List;



public interface BookingService {
    List<Booking> getAllBookings();
    Booking getBookingById(Integer id);
    Booking createBooking(BookingPojo bookingPojo);
    Booking updateBooking(BookingPojo bookingPojo);
    void deleteBooking(Integer id);


}
