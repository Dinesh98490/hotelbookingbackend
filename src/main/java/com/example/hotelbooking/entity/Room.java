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

    @Column( nullable = false, length = 10)
    private String roomfloor;

    @Column( nullable = false, length = 100)
    private String roomtype;

    @Column( nullable = false, length = 10)
    private String pricepernight;

    @Column( nullable = false, length = 100)
    private String availabilitystatus;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotelid", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_hotel_room"))
    private Hotel hotel;

    public Integer getHotelId() {
        return hotel.getId();
    }
}
