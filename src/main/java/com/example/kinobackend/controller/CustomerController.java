package com.example.kinobackend.controller;

import com.example.kinobackend.model.Customer;
import com.example.kinobackend.repositories.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin ("*")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @GetMapping("/search")
    public ResponseEntity<List<Customer>> searchCustomersByName(@RequestParam(required = false) String name) {
        if (name != null && !name.trim().isEmpty()) {
            List<Customer> customers = customerRepository.findByNameContainingIgnoreCase(name);
            return ResponseEntity.ok(customers);
        }
        return ResponseEntity.ok(customerRepository.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        return customerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}