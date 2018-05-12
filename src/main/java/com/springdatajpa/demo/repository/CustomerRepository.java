package com.springdatajpa.demo.repository;

import com.springdatajpa.demo.Model.Customer;

import java.util.Map;

public interface CustomerRepository {

    void save(Customer customer);
    Customer find(Long id);
    Map<Long, Customer> findAll();
    void update(Customer customer);
    void delete(Long id);

}
