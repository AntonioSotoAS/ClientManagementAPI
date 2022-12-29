package com.ClientManagement.domain.repository;

import com.ClientManagement.domain.Customer;
import com.ClientManagement.domain.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    List<CustomerDTO> getAll();
    Optional<List<CustomerDTO>> getByCustomer(int customerId);
    Optional<CustomerDTO> getCustomer(int customerId);
    CustomerDTO save (CustomerDTO customer);

    CustomerDTO update(CustomerDTO customer);
    void delete(int customerId);

}
