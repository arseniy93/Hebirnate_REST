package com.rigin.model.mapper;

import com.rigin.model.dto.UserDto;
import com.rigin.model.dto.UserLogInDto;
import com.rigin.model.dto.UserSignInDto;
import com.rigin.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDtoTo(User user);
    User userDtoToUser(UserDto userDto);

    UserLogInDto userToUserCommand(User user);
    User userCommandToUser(UserLogInDto userLogInDto);

    UserDto userCommandToUserDto(UserLogInDto userLogInDto);
    UserLogInDto userDtoToUserCommand(UserDto userDto);

    User registerUser(UserSignInDto userSignInDto);

}
