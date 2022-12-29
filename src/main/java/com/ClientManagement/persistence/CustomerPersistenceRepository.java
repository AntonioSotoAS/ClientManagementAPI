package com.ClientManagement.persistence;

import com.ClientManagement.domain.dto.CustomerDTO;
import com.ClientManagement.domain.repository.CustomerRepository;
import com.ClientManagement.persistence.crud.CustomerCrudRepository;
import com.ClientManagement.persistence.entity.Customer;
import com.ClientManagement.persistence.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerPersistenceRepository implements CustomerRepository {

    @Autowired
    private CustomerCrudRepository customerCrudRepository;

    @Autowired
    private CustomerMapper mapper;

    @Override
    public List<CustomerDTO> getAll() {
        return mapper.toCustomerDTOs((List<Customer>) customerCrudRepository.findAll());
    }

    @Override
    public Optional<List<CustomerDTO>> getByCustomer(int customerId) {
        return customerCrudRepository.findAllByIdCustomer(customerId)
                .map(customers -> mapper.toCustomerDTOs(customers));
    }

    @Override
    public Optional<CustomerDTO> getCustomer(int customerId) {
        return customerCrudRepository.findById(customerId)
                .map(customer -> mapper.toCustomerDTO(customer));
    }

    @Override
    public CustomerDTO save(CustomerDTO customer) {
        Customer customerEntity = mapper.toCustomerDTO(customer);

        return mapper.toCustomerDTO(customerCrudRepository.save(customerEntity));
    }

    @Override
    public CustomerDTO update(CustomerDTO customer) {
        return getCustomer(customer.getIdCustomer())
                .map(customertoUpdate -> {
                    customertoUpdate.setBrand(customer.getBrand());
                    customertoUpdate.setDni(customer.getDni());
                    customertoUpdate.setName(customer.getName());
                    customertoUpdate.setLastName(customer.getLastName());
                    customertoUpdate.setPhone(customer.getPhone());
                    customertoUpdate.setEmail(customer.getEmail());
                    customertoUpdate.setPhone(customer.getPhone());
                    Customer customerEntity = mapper.toCustomerDTO(customertoUpdate);
                    return save(mapper.toCustomerDTO(customerEntity));
                }).orElse(null);
    }

    @Override
    public void delete(int customerId) {
        customerCrudRepository.deleteById(customerId);
    }
}
