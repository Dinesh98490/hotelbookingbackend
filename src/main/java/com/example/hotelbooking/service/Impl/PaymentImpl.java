package com.example.hotelbooking.service.Impl;

import com.example.hotelbooking.entity.Booking;
import com.example.hotelbooking.entity.Payment;
import com.example.hotelbooking.pojo.PaymentPojo;
import com.example.hotelbooking.repository.BookingRepository;
import com.example.hotelbooking.repository.PaymentRepository;
import com.example.hotelbooking.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PaymentImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final BookingRepository bookingRepository;

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment findById(Integer id) {
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        return optionalPayment.orElse(null);
    }

    @Override
    public Payment save(PaymentPojo paymentPojo) {
        Payment payment = new Payment();
        payment.setAmount(paymentPojo.getAmount());
        payment.setPaymentDate(paymentPojo.getPaymentDate());
        payment.setPaymentMethod(paymentPojo.getPaymentMethod());

        Optional<Booking> optionalBooking = bookingRepository.findById(paymentPojo.getBookingId());
        if (optionalBooking.isPresent()) {
            Booking booking = optionalBooking.get();
            payment.setBooking(booking);
        }

        return paymentRepository.save(payment);
    }

    @Override
    public Payment update( PaymentPojo paymentPojo) {
        Optional<Payment> optionalPayment = paymentRepository.findById(paymentPojo.getId());
        if (optionalPayment.isPresent()) {
            Payment payment = optionalPayment.get();
            payment.setAmount(paymentPojo.getAmount());
            payment.setPaymentDate(paymentPojo.getPaymentDate());
            payment.setPaymentMethod(paymentPojo.getPaymentMethod());

            Optional<Booking> optionalBooking = bookingRepository.findById(paymentPojo.getBookingId());
            if (optionalBooking.isPresent()) {
                Booking booking = optionalBooking.get();
                payment.setBooking(booking);
            }

            return paymentRepository.save(payment);
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        paymentRepository.deleteById(id);
    }
}
