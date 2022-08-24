package com.sigma.appoilstation.mapper;

import com.sigma.appoilstation.entity.User;
import com.sigma.appoilstation.payload.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDTO userDTO);

    void update(UserDTO userDTO,@MappingTarget User user);
}
