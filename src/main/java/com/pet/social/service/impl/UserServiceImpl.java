package com.pet.social.service.impl;

import com.pet.social.dto.UserDto;
import com.pet.social.model.User;
import com.pet.social.service.EntityService;
import com.pet.social.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final JdbcTemplate jdbcTemplate;
    private final EntityService service;


    @Override
    public UserDto getUser(Long id) {
        return Optional.of(jdbcTemplate.query("""
                    SELECT email, username
                    FROM APP_USER
                    WHERE id = ?
                """, (rs, rowNum) -> new UserDto(rs.getString("email"), rs.getString("username")), id).stream().findFirst()).get().orElse(null);

    }

    @Override
    public void addUser(UserDto userDto) {
        User user = User.builder()
                .id(null)
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password("password")
                .build();
        service.setEntity(user);
    }
}
