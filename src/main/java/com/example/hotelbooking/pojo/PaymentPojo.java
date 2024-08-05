package com.example.hotelbooking.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentPojo {
    private Integer id;
//    private Date paymentDate;
    private String Amount;
    private String paymentMethod;
    private int  bookingId;
}
