package com.example.hotelbooking.service.Impl;

import com.example.hotelbooking.entity.Customer;
import com.example.hotelbooking.pojo.CustomerPojo;
import com.example.hotelbooking.repository.CustomerRepository;
import com.example.hotelbooking.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer saveCustomer(CustomerPojo customerPojo) {
        Customer customer = new Customer();
        customer.setFirstName(customerPojo.getFirstName());
        customer.setLastName(customerPojo.getLastName());
        customer.setEmail(customerPojo.getEmail());
        customer.setPhoneNumber(customerPojo.getPhoneNumber());
        customer.setAddress(customerPojo.getAddress());
        customer.setCitizenshipNo(customerPojo.getCitizenShipNo());
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer( CustomerPojo customerPojo) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerPojo.getId());
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setFirstName(customerPojo.getFirstName());
            customer.setLastName(customerPojo.getLastName());
            customer.setEmail(customerPojo.getEmail());
            customer.setPhoneNumber(customerPojo.getPhoneNumber());
            customer.setAddress(customerPojo.getAddress());
            customer.setCitizenshipNo(customerPojo.getCitizenShipNo());
            return customerRepository.save(customer);
        }
        return null;
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}
