package com.ClientManagement.domain.repository;

import com.ClientManagement.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    List<Customer> getAll();
    Optional<List<Customer>> getByCustomer(int customerId);
    Optional<Customer> getCustomer(int customerId);
    Customer save (Customer customer);

    Customer update(Customer customer);
    void delete(int customerId);

}
