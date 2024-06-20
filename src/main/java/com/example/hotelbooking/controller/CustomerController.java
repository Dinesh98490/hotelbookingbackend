package com.example.hotelbooking.controller;


import com.example.hotelbooking.entity.Customer;
import com.example.hotelbooking.entity.Hotel;
import com.example.hotelbooking.pojo.CustomerPojo;
import com.example.hotelbooking.service.CustomerService;
import com.example.hotelbooking.shared.pojo.GlobalApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<GlobalApiResponse<List<Customer>>> getAllCustomers() {
        List<Customer> hotels =customerService.getAllCustomers();
        GlobalApiResponse<List<Customer>> globalApiResponse = new GlobalApiResponse<>("data  retrieved successfully",200,hotels);
        return ResponseEntity.ok(globalApiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Customer>> getCustomerById(@PathVariable Integer id)
    {
        Customer customer = customerService.getCustomer(id);
        GlobalApiResponse<Customer>  globalApiResponse = new GlobalApiResponse<>("data  retrieved successfully",200,customer);
        return ResponseEntity.ok(globalApiResponse);

    }

    @PostMapping
    public ResponseEntity<GlobalApiResponse<Customer>> saveCustomer(@RequestBody CustomerPojo id){

        Customer customer = customerService.saveCustomer(id);
        GlobalApiResponse<Customer>  globalApiResponse = new GlobalApiResponse<>("data  created  successfully",201,customer);
        return ResponseEntity.ok(globalApiResponse);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Void>> deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        GlobalApiResponse<Void>  globalApiResponse = new GlobalApiResponse<>("data  deleted successfully",201,null);
        return ResponseEntity.ok(globalApiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Customer>> updateCustomer(@RequestBody CustomerPojo customerPojo, @PathVariable Integer id){
        Customer customer = customerService.updateCustomer(customerPojo,id);
        GlobalApiResponse<Customer>  globalApiResponse = new GlobalApiResponse<>("data  updated successfully",201,customer);
        return ResponseEntity.ok(globalApiResponse);


    }




}
