package com.ClientManagement.persistence.mapper;


import com.ClientManagement.domain.dto.ClientPorfolioDTO;
import com.ClientManagement.persistence.entity.ClientPorfolio;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper(componentModel = "spring",uses = {CustomerMapper.class})
public interface ClientPorfolioMapper {

    @Mappings({
            @Mapping(source = "idClientPorfolio",target = "idClientPorfolioDTO"),
            @Mapping(source = "seller",target = "sellerDTO"),
            @Mapping(source = "customer",target = "customerDTO")
    })
    ClientPorfolioDTO toClientPorfolioDTO(ClientPorfolio clientPorfolio);

    List<ClientPorfolioDTO> toClientPorfolioDTOs(List<ClientPorfolio> clientPorfolios);

    @InheritInverseConfiguration
    ClientPorfolio toClientPorfolio(ClientPorfolioDTO clientPorfolio);


}
