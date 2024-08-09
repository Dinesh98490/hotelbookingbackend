package com.example.hotelbooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_setup_seq_gen")
    @SequenceGenerator(name = "booking_setup_seq_gen", sequenceName = "booking_setup_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "firstName", nullable = false, length = 100)
    private String firstname;

    @Column(name = "lastName", nullable = false, length = 100)
    private String lastname;

    @Column(name = "address", nullable = false, length = 100)
    private String address;

    @Column(name = "gender", nullable = false, length = 10)
    private String gender;

    @Column(name = "nationality",  nullable = false, length = 10)
    private String nationality;





    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "pk_id_fk_customer_id"))
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "pk_id_fk_room_id"))
    private Room room;
}
