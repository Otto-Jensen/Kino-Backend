package com.example.kinobackend.repositories;

import com.example.kinobackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // Søg efter kundenavn (delvis og case-insensitive match til User Story 6)
    List<Customer> findByNameContainingIgnoreCase(String name);
}