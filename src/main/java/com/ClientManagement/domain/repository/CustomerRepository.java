package com.ClientManagement.domain.repository;

import com.ClientManagement.domain.Customer;
import com.ClientManagement.domain.dto.CustomerDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CustomerRepository {

    List<CustomerDTO> getAll();
    Optional<CustomerDTO> getCustomer(int customerId);
    CustomerDTO save (CustomerDTO customer);

    CustomerDTO update(CustomerDTO customer);
    void delete(int customerId);

}
