package com.pet.social.service.impl;

import com.pet.social.service.EntityService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntityServiceImpl implements EntityService {

    private final EntityManagerFactory entityManagerFactory;

    public  <T> void setEntity(T entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
