package com.pet.social.dao;

import jakarta.persistence.Id;


public class UserDao {

    @Id
    private Long id;
    private String username;

}
