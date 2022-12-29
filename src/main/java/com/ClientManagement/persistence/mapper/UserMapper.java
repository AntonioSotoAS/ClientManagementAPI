package com.ClientManagement.persistence.mapper;

import com.ClientManagement.domain.dto.UserDTO;
import com.ClientManagement.persistence.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper(componentModel = "spring",uses = {RoleMapper.class})
public interface UserMapper {

    @Mappings({
            @Mapping(source = "idUser",target = "idUser"),
            @Mapping(source = "role",target = "role"),
            @Mapping(source = "username",target = "username"),
            @Mapping(source = "password" ,target = "password")

    })
    UserDTO toUserDTO(User user);

    List<UserDTO> toUserDTOs(List<User> users);

    @InheritInverseConfiguration
    User toUser(UserDTO user);

}
