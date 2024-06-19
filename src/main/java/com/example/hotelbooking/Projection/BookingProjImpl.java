package com.example.hotelbooking.Projection;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookingProjImpl implements BookingProj {
    private Integer id;
    private Integer customerId;
    private Integer roomId;



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
