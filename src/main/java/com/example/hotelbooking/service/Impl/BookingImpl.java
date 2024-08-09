package com.example.hotelbooking.service.Impl;

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

@Service
@RequiredArgsConstructor
public class BookingImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final RoomRepository roomRepository;

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(Integer id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public Booking createBooking(BookingPojo bookingPojo) {
        Booking booking = new Booking();
        Optional<Customer> optionalCustomer = customerRepository.findById(bookingPojo.getCustomerId());
        optionalCustomer.ifPresent(booking::setCustomer);

        Optional<Room> optionalRoom = roomRepository.findById(bookingPojo.getRoomId());
        optionalRoom.ifPresent(booking::setRoom);

        booking.setFirstname(bookingPojo.getFirstname());
        booking.setLastname(bookingPojo.getLastname());
        booking.setAddress(bookingPojo.getAddress());
        booking.setGender(bookingPojo.getGender());
        booking.setNationality(bookingPojo.getNationality());

        return bookingRepository.save(booking);
    }

    @Override
    public Booking updateBooking(Integer id, BookingPojo bookingPojo) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        if (optionalBooking.isPresent()) {
            Booking booking = optionalBooking.get();
            Optional<Customer> optionalCustomer = customerRepository.findById(bookingPojo.getCustomerId());
            optionalCustomer.ifPresent(booking::setCustomer);

            Optional<Room> optionalRoom = roomRepository.findById(bookingPojo.getRoomId());
            optionalRoom.ifPresent(booking::setRoom);

            booking.setFirstname(bookingPojo.getFirstname());
            booking.setLastname(bookingPojo.getLastname());
            booking.setAddress(bookingPojo.getAddress());
            booking.setGender(bookingPojo.getGender());
            booking.setNationality(bookingPojo.getNationality());

            return bookingRepository.save(booking);
        }
        return null;
    }

    @Override
    public void deleteBooking(Integer id) {
        bookingRepository.deleteById(id);
    }
}
