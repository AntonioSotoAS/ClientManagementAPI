package com.ClientManagement.persistence.mapper;

import com.ClientManagement.domain.dto.RoleDTO;
import com.ClientManagement.domain.dto.SellerDTO;
import com.ClientManagement.persistence.entity.Role;
import com.ClientManagement.persistence.entity.Seller;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper(componentModel = "spring",uses = {ClientPorfolioMapper.class})
public interface SellerMapper {

    @Mappings({
            @Mapping(source = "idSeller",target = "idSellerDTO"),
            @Mapping(source = "dni",target = "dniDTO"),
            @Mapping(source = "name" ,target = "nameDTO"),
            @Mapping(source = "lastName" ,target = "lastNameDTO")
    })
    SellerDTO toSellerDTO(Seller seller);

    List<SellerDTO> toSellerDTOs(List<Seller> roles);

    @InheritInverseConfiguration
    Seller toSeller(SellerDTO seller);

}
