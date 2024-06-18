package com.example.hotelbooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_setup_seq_gen")
    @SequenceGenerator(name = "room_setup_seq_gen", sequenceName = "room_setup_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "roomNumber", nullable = false, length = 10)
    private Integer roomNumber;

    @Column(name = "roomType", nullable = false, length = 100)
    private String roomType;

    @Column(name = "pricePerNight", nullable = false, length = 10)
    private Integer pricePerNight;

    @Column(name = "availabilityStatus", nullable = false, length = 100)
    private String availabilityStatus;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_hotel_room"))
    private Hotel hotel;
}
