package com.store.basma;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class BasmaApplication
{
   /* @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;*/

    public static void main(String[] args) {
        SpringApplication.run(BasmaApplication.class, args);
    }
/*
    @Override
    public void run(String... args) throws Exception {
     *//*  Role role = new Role(3L,"rick");
        Role role2 = new Role(4L,"rick");*//*

       User user = new User("rick","morty","rick@gmail.com","$2a$10$k8GVxicEFvR76e5h21.n0.KyVE9K.UQh5Jl423e493RR0QqEtT28O","rick123",true);
       *//*user.setRoles(role,role2);*//*
        //userRepository.save(user);
        //roleRepository.save(role);
        //System.out.println(userRepository.findAll()); ;

    }*/
}
