package com.example.tinder.mapper;

import com.example.tinder.model.dto.UserDto;
import com.example.tinder.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto entityToDto(UserEntity user);

//    List<StudentDto> entityToDto(List<StudentEntity> students);


    UserEntity dtoToEntity(UserDto userDto);


}
