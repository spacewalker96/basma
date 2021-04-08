package com.store.basma.service;

import com.store.basma.enity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {


    public List<User> findAll();

    public User findById(Long theId);
    public User findByEmailContains(String email);

    public void save(User theUser);

    public void deleteById(Long theId);
}

/*public interface UserService extends UserDetailsService {

    public List<User> findAll();

    public User findById(long theId);

    public void save(User theUser);

    public void deleteById(long theId);
}*/
