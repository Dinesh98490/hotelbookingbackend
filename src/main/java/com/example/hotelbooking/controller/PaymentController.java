package com.example.hotelbooking.controller;


import com.example.hotelbooking.entity.Hotel;
import com.example.hotelbooking.entity.Payment;
import com.example.hotelbooking.pojo.PaymentPojo;
import com.example.hotelbooking.service.PaymentService;
import com.example.hotelbooking.shared.pojo.GlobalApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@AllArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping
    public ResponseEntity<GlobalApiResponse<List<Payment>>>  findAll(){
        List<Payment> payments = paymentService.findAll();
        GlobalApiResponse<List<Payment>>  globalApiResponse = new GlobalApiResponse<>("data retrived successfully", 200, payments);
        return ResponseEntity.ok(globalApiResponse);

    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Payment>>  findById(@PathVariable Integer id){
        Payment payments = paymentService.findById(id);

        GlobalApiResponse <Payment> globalApiResponse = new GlobalApiResponse<>("data retrived successfully", 200, payments);
        return ResponseEntity.ok(globalApiResponse);

    }

    @PostMapping
    public ResponseEntity<GlobalApiResponse<Payment>>  save (@RequestBody PaymentPojo payment){
        Payment payments = paymentService.save(payment);

        GlobalApiResponse <Payment> globalApiResponse = new GlobalApiResponse<>("data created successfully", 201, payments);
        return ResponseEntity.ok(globalApiResponse);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Void>> deleteById(@PathVariable Integer id){

        paymentService.deleteById(id);
        GlobalApiResponse <Void> globalApiResponse = new GlobalApiResponse<>("data deleted successfully", 201, null);
        return ResponseEntity.ok(globalApiResponse);

    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Payment>>update (@PathVariable PaymentPojo payment){
        Payment payments = paymentService.update(payment);

        GlobalApiResponse <Payment> globalApiResponse = new GlobalApiResponse<>("data updated  successfully", 201, null);
        return ResponseEntity.ok(globalApiResponse);

    }


}
