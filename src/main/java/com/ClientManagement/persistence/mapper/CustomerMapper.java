package com.ClientManagement.persistence.mapper;

import com.ClientManagement.domain.dto.CustomerDTO;
import com.ClientManagement.persistence.entity.Customer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper(componentModel = "spring",uses = {BrandMapper.class})
public interface CustomerMapper {

    @Mappings({
            @Mapping(source = "idCustomer",target = "idCustomer"),
            @Mapping(source = "brand",target = "brand"),
            @Mapping(source = "dni",target = "dni"),
            @Mapping(source = "name",target = "name"),
            @Mapping(source = "lastName",target = "lastName"),
            @Mapping(source = "phone",target = "phone"),
            @Mapping(source = "email",target = "email"),
            @Mapping(source = "photo",target = "photo")
    })
    CustomerDTO toCustomerDTO(Customer customer);

    List<CustomerDTO> toCustomerDTOs(List<Customer> customers);

    @InheritInverseConfiguration
    Customer toCustomerDTO(CustomerDTO customer);

}
