package com.example.hotelbooking.Projection;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookingProjImpl implements BookingProj {
    private Integer id;
    private Integer customerId;
    private Integer roomId;

//    // Constructor to initialize fields
//    public BookingProjImpl(Integer id, Integer customerId, Integer roomId) {
//        this.id = id;
//        this.customerId = customerId;
//        this.roomId = roomId;
//    }

    @Override
    public Integer getID() {
        return id;
    }

    @Override
    public Integer getCustomerID() {
        return customerId;
    }

    @Override
    public Integer getRoomID() {
        return roomId;
    }
}
