package com.example.tinder.mapper;

import com.example.tinder.model.dto.ProfileDto;
import com.example.tinder.model.dto.UserDto;
import com.example.tinder.model.entity.ProfileEntity;
import com.example.tinder.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProfileMapper {
    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

    ProfileDto entityToDto(ProfileEntity profile);

    List<ProfileDto> entityToDto(List<ProfileEntity> profiles);

    UserEntity dtoToEntity(UserDto userDto);


}
