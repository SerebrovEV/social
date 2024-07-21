package com.pet.social.controller;

import com.pet.social.dto.UserDto;
import com.pet.social.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @Transactional
    @GetMapping(value = "/{id}", produces = "application/json")
    public @ResponseBody UserDto getUser(@PathVariable("id") Long id) {
        log.info("Getting user with id: {}", id);
        return userService.getUser(id);
    }

    @Transactional
    @PostMapping(consumes = "application/json")
    public void createUser(@RequestBody UserDto userDto) {
        log.info("Creating user: {}", userDto);
        userService.addUser(userDto);
    }
}
