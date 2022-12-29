package com.ClientManagement.persistence.mapper;

import com.ClientManagement.domain.dto.BrandDTO;
import com.ClientManagement.domain.dto.RoleDTO;
import com.ClientManagement.persistence.entity.Brand;
import com.ClientManagement.persistence.entity.Role;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mappings({
            @Mapping(source = "idRole",target = "idRoleDTO"),
            @Mapping(source = "roleType",target = "roleTypeDTO")
    })
    RoleDTO toRoleDTO(Role role);

    List<RoleDTO> toRoleDTOs(List<Role> roles);

    @InheritInverseConfiguration
    Role toRole(RoleDTO role);

}
