package com.example.hotelbooking.service.Impl;

import com.example.hotelbooking.Projection.BookingProj;
import com.example.hotelbooking.entity.Booking;
import com.example.hotelbooking.entity.Customer;
import com.example.hotelbooking.entity.Room;
import com.example.hotelbooking.pojo.BookingPojo;
import com.example.hotelbooking.repository.BookingRepository;
import com.example.hotelbooking.repository.CustomerRepository;
import com.example.hotelbooking.repository.RoomRepository;
import com.example.hotelbooking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
public class BookingImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final RoomRepository roomRepository;

    @Override
    public List<Booking> getAllBookings()
    {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(Integer id){
        return bookingRepository.findById(id).orElse(null);
    }
    @Override
    public Booking createBooking(BookingPojo bookingPojo){
        Booking booking = new Booking();
        Optional<Customer> optionalCustomer = customerRepository.findById(bookingPojo.getCustomerId());
        if(optionalCustomer.isPresent()){
            Customer customer = optionalCustomer.get();
            booking.setCustomer(customer);
        }
        Optional<Room> optionalRoom = roomRepository.findById(bookingPojo.getRoomId());
        if(optionalRoom.isPresent()){
            Room room = optionalRoom.get();
            booking.setRoom(room);
        }
        return bookingRepository.save(booking);
    }
    @Override
    public Booking updateBooking(BookingPojo bookingPojo){
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        if(optionalBooking.isPresent()){
            Booking booking = optionalBooking.get();
            Optional<Customer> optionalCustomer = customerRepository.findById(bookingPojo.getCustomerId());
            if(optionalCustomer.isPresent()){
                Customer customer = optionalCustomer.get();
                booking.setCustomer(customer);
            }
            Optional<Room> optionalRoom = roomRepository.findById(bookingPojo.getRoomId());
            if(optionalRoom.isPresent()){
                Room room = optionalRoom.get();
                booking.setRoom(room);
            }
            return bookingRepository.save(booking);
        }
        return null;
    }

    @Override
    public void deleteBooking(Integer id){
        bookingRepository.deleteById(id);
    }


}
