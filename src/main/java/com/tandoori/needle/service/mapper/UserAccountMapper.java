package com.tandoori.needle.service.mapper;

import com.tandoori.needle.service.model.UserAccount;
import com.tandoori.needle.web.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface UserAccountMapper {

    UserAccountMapper instance = Mappers.getMapper(UserAccountMapper.class);

    UserAccount fromUserDTO(UserDTO userDTO);
}
