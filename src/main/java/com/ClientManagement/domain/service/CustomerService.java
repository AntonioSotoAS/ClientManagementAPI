package com.ClientManagement.domain.service;

import com.ClientManagement.domain.Customer;
import com.ClientManagement.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAll(){
        return customerRepository.getAll();
    }
    public Optional<List<Customer>> getByCustomer(int customerId){
        return customerRepository.getByCustomer(customerId);
    }
    public Optional<Customer> getCustomer(int customerId){
        return customerRepository.getCustomer(customerId);
    }
    public Customer save (Customer customer){
        return customerRepository.save(customer);
    }
    public Customer update(Customer customer){
        return customerRepository.update(customer);
    }
    public boolean delete(int customerId){
        if (getCustomer(customerId).isPresent()){
            customerRepository.delete(customerId);
            return true;
        }else {
            return false;
        }
    }
}
