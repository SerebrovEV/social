package com.pet.social.service;

import com.pet.social.dto.UserDto;

public interface UserService {

    UserDto getUser(Long id);

    void addUser(UserDto userDto);
}
