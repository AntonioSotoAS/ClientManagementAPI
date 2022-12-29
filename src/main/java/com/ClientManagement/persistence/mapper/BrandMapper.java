package com.ClientManagement.persistence.mapper;

import com.ClientManagement.domain.dto.BrandDTO;
import com.ClientManagement.persistence.entity.Brand;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;
@Component

@Mapper(componentModel = "spring")
public interface BrandMapper {

    @Mappings({
            @Mapping(source = "idBrand",target = "idBrandDTO"),
            @Mapping(source = "brand",target = "brandDTO")
    })
    BrandDTO toBrandDTO(Brand brand);

    List<BrandDTO> toBrandDTOs(List<Brand> brands);

    @InheritInverseConfiguration
    Brand toBrand(BrandDTO brand);

}
