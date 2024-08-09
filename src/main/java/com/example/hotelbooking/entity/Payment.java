package com.example.hotelbooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "payment")
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_setup_seq_gen")
    @SequenceGenerator(name = "payment_setup_seq_gen", sequenceName = "payment_setup_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "paymentDate", nullable = false, length = 100)
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @Column(name = "amount", nullable = false, length = 100)
    private String amount;

    @Column(name = "paymentMethod", nullable = false, length = 100)
    private String paymentMethod;

    @Column(name = "firstName", nullable = false, length = 100)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 100)
    private String lastName;

    @OneToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
    private Booking booking;
}
