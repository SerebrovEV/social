//package com.pet.social.configuration;
//
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.spi.PersistenceProvider;
//import lombok.extern.slf4j.Slf4j;
//import org.hibernate.jpa.HibernatePersistenceProvider;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.URL;
//import java.util.Enumeration;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Objects;
//
//import static jakarta.persistence.Persistence.createEntityManagerFactory;
//
//@Slf4j
//@Configuration
//public class HibernateConfiguration {
//
//
//    public static EntityManagerFactory createEntityManagerFactory() {
//        PersistenceProvider persistenceProvider = new HibernatePersistenceProvider();
//        Map<String, String> properties = new HashMap<>();
//        properties.put("jakarta.persistence.url","jdbc:postgresql://localhost:5432/note");
//        properties.put("jakarta.persistence.username", "admin");
//        properties.put("jakarta.persistence.password", "password");
//        Map<String, Class<?>> classMap = new HashMap<>();
//        String packageName = "com.pet.social.model";
//        try {
//            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//            String path = packageName.replace(".", "/");
//            Enumeration<URL> resources = classLoader.getResources(path);
//            while (resources.hasMoreElements()) {
//                File file = new File(resources.nextElement().getFile());
//                if (file.isDirectory()) {
//                    for (File classFile : Objects.requireNonNull(file.listFiles())) {
//                        if (classFile.getName().endsWith(".class")) {
//                            String className = packageName + "." + classFile.getName().replace(".class", "");
//                            Class<?> clazz = Class.forName(className);
//                            classMap.put(clazz.getSimpleName(), clazz);
//                            log.info("Add class: %s".formatted(className));
//                            properties.put("jakarta.persistence.entity", className);
//                        }
//                    }
//                }
//            }
//            System.out.println(classMap);
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return persistenceProvider.createEntityManagerFactory("myPersistenceUnit", properties);
//    }
//}
