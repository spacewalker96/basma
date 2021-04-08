package com.store.basma.service;

import com.store.basma.enity.User;
import com.store.basma.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository theUserRepository) {
        userRepository = theUserRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long theId) {
        Optional<User> result = userRepository.findById(theId);

        User theUser = null;

        if (result.isPresent()) {
            theUser = result.get();
        }
        else {
            // we didn't find the user
            throw new RuntimeException("Did not find user id - " + theId);
        }

        return theUser;
    }

    @Override
    public User findByEmailContains(String email) {
        return userRepository.findByEmailContains(email);
    }


    @Override
    public void save(User theUser) {
        userRepository.save(theUser);
    }

    @Override
    public void deleteById(Long theId) {
        userRepository.deleteById(theId);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
        /*return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getEncryptedPassword(),
                mapRolesToAuthorities(user.getRoles()));*/


    /*private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }*/


/*@Service
public class UserServiceImpl implements UserService{


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(@Qualifier("userRepositoryImpl") UserRepository theuserRepository) {
        userRepository = theuserRepository;
    }

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User findById(long theId) {
        return userRepository.findById(theId);
    }

    @Override
    @Transactional
    public void save(User theUser) {
       theUser.setEncryptedPassword(bCryptPasswordEncoder.encode(theUser.getEncryptedPassword()));
        userRepository.save(theUser);
    }

    @Override
    @Transactional
    public void deleteById(long theId) {
        userRepository.deleteById(theId);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}*/
