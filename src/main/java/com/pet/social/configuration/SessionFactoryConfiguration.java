package com.pet.social.configuration;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

@Configuration
@RequiredArgsConstructor
public class SessionFactoryConfiguration {

    private final SpringJdbcConfig springJdbcConfig;


    public SessionFactory buildSessionFactory() {
        return new LocalSessionFactoryBuilder(springJdbcConfig.dataSource()).buildSessionFactory();
    }
}