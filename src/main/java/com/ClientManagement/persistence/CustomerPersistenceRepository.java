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
    private CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> getAll() {
        return customerMapper.toCustomerDTOs((List<Customer>) customerCrudRepository.findAll());
    }

    @Override
    public Optional<CustomerDTO> getCustomer(int customerId) {
        return customerCrudRepository.findById(customerId)
                .map(customer -> customerMapper.toCustomerDTO(customer));
    }

    @Override
    public CustomerDTO save(CustomerDTO customer) {
        Customer customerEntity = customerMapper.toCustomerDTO(customer);

        return customerMapper.toCustomerDTO(customerCrudRepository.save(customerEntity));
    }

    @Override
    public CustomerDTO update(CustomerDTO customer) {
        return getCustomer(customer.getIdCustomerDTO())
                .map(customertoUpdate -> {
                    customertoUpdate.setBrandDTO(customer.getBrandDTO());
                    customertoUpdate.setDniDTO(customer.getDniDTO());
                    customertoUpdate.setNameDTO(customer.getNameDTO());
                    customertoUpdate.setLastNameDTO(customer.getLastNameDTO());
                    customertoUpdate.setEmailDTO(customer.getEmailDTO());
                    customertoUpdate.setPhoneDTO(customer.getPhoneDTO());
                    customertoUpdate.setAgeDTO(customer.getAgeDTO());
                    Customer customerEntity = customerMapper.toCustomerDTO(customertoUpdate);
                    return save(customerMapper.toCustomerDTO(customerEntity));
                }).orElse(null);
    }

    @Override
    public void delete(int customerId) {
        customerCrudRepository.deleteById(customerId);
    }
}
