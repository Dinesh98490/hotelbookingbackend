package com.example.hotelbooking.repository;


import com.example.hotelbooking.Projection.BookingProj;
import com.example.hotelbooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;



// BookingRepository.java
@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
}

