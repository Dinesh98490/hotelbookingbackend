package com.example.hotelbooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hotels")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotels_setup_seq_gen")
    @SequenceGenerator(name = "hotels_setup_seq_gen", sequenceName = "hotels_setup_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "hotelName", nullable = false, length = 100)
    private String hotelName;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "address", nullable = false, length = 100)
    private String address;

    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @Column(name = "phoneNumber", nullable = false, length = 10)
    private long phoneNumber;

    @Column(unique = true, nullable = false, length = 100)
    private String email;
}
