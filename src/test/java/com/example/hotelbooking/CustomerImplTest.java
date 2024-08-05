package com.example.hotelbooking;


import com.example.hotelbooking.entity.Customer;
import com.example.hotelbooking.pojo.CustomerPojo;
import com.example.hotelbooking.repository.CustomerRepository;
import com.example.hotelbooking.service.Impl.CustomerImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerImpl customerImpl;

    @Test
    public void testGetAllCustomers() {
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer1, customer2));

        assertEquals(2, customerImpl.getAllCustomers().size());
    }

    @Test
    public void testGetCustomer() {
        Customer customer = new Customer();
        when(customerRepository.findById(anyInt())).thenReturn(Optional.of(customer));

        Customer result = customerImpl.getCustomer(1);
        assertNotNull(result);
        assertEquals(customer, result);
    }

    @Test
    public void testGetCustomerNotFound() {
        when(customerRepository.findById(anyInt())).thenReturn(Optional.empty());

        Customer result = customerImpl.getCustomer(1);
        assertNull(result);
    }

    @Test
    public void testSaveCustomer() {
        CustomerPojo customerPojo = new CustomerPojo();
        customerPojo.setFirstName("John");
        customerPojo.setLastName("Doe");
        customerPojo.setEmail("john.doe@example.com");
        customerPojo.setPhoneNumber("1234567890");
        customerPojo.setAddress("123 Main St");
        customerPojo.setCitizenshipNo("A123456789");

        Customer customer = new Customer();
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        Customer savedCustomer = customerImpl.saveCustomer(customerPojo);
        assertNotNull(savedCustomer);
        verify(customerRepository, times(1)).save(any(Customer.class));
    }

    @Test
    public void testUpdateCustomer() {
        CustomerPojo customerPojo = new CustomerPojo();
        customerPojo.setId(1);
        customerPojo.setFirstName("John");
        customerPojo.setLastName("Doe");

        Customer existingCustomer = new Customer();
        existingCustomer.setId(1);
        when(customerRepository.findById(anyInt())).thenReturn(Optional.of(existingCustomer));
        when(customerRepository.save(any(Customer.class))).thenReturn(existingCustomer);

        Customer updatedCustomer = customerImpl.updateCustomer(customerPojo, 1);
        assertNotNull(updatedCustomer);
        assertEquals("John", updatedCustomer.getFirstName());
        verify(customerRepository, times(1)).save(existingCustomer);
    }

    @Test
    public void testUpdateCustomerNotFound() {
        CustomerPojo customerPojo = new CustomerPojo();
        customerPojo.setId(1);

        when(customerRepository.findById(anyInt())).thenReturn(Optional.empty());

        Customer updatedCustomer = customerImpl.updateCustomer(customerPojo, 1);
        assertNull(updatedCustomer);
    }

    @Test
    public void testDeleteCustomer() {
        customerImpl.deleteCustomer(1);
        verify(customerRepository, times(1)).deleteById(1);
    }
}
