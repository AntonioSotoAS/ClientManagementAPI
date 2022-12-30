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
            @Mapping(source = "idCustomer",target = "idCustomerDTO"),
            @Mapping(source = "brand",target = "brandDTO"),
            @Mapping(source = "dni",target = "dniDTO"),
            @Mapping(source = "name",target = "nameDTO"),
            @Mapping(source = "lastName",target = "lastNameDTO"),
            @Mapping(source = "age",target = "ageDTO"),
            @Mapping(source = "phone",target = "phoneDTO"),
            @Mapping(source = "email",target = "emailDTO")
    })
    CustomerDTO toCustomerDTO(Customer customer);

    List<CustomerDTO> toCustomerDTOs(List<Customer> customers);

    @InheritInverseConfiguration
    Customer toCustomerDTO(CustomerDTO customer);

}
