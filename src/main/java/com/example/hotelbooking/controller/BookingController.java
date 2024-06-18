package com.example.hotelbooking.controller;


import com.example.hotelbooking.Projection.BookingProj;
import com.example.hotelbooking.entity.Booking;
import com.example.hotelbooking.pojo.BookingPojo;
import com.example.hotelbooking.service.BookingService;
import com.example.hotelbooking.shared.pojo.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.aop.framework.adapter.GlobalAdvisorAdapterRegistry;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("booking")
public class BookingController {
    private final BookingService bookingService;

    @GetMapping
    public GlobalApiResponse<List<BookingProj>> getData(BookingProj bookingProj) {
        return GlobalApiResponse.
                <List<BookingProj>>builder()
                .data(this.bookingService.getAllBookings())
                .statusCode(200)
                .message("data retreived successfully")
                .build();
    }

}





