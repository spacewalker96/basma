package com.store.basma.controller;


import com.store.basma.enity.User;
import com.store.basma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
/*@RequestMapping("/api")*/
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService theUserService) {
        userService = theUserService;
    }

    // expose "/users" and return list of users
    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    // add mapping for GET /users/{userId}

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable Long userId) {

        User theUser = userService.findById(userId);

        if (theUser == null) {
            throw new RuntimeException("User id not found - " + userId);
        }

        return theUser;
    }

    // add mapping for POST /users - add new user

    @PostMapping("/addUser")
    public User addUser(@RequestBody User theUser) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theUser.setId(0L);

        userService.save(theUser);

        return theUser;
    }

    // add mapping for PUT /users - update existing user

    @PutMapping("/users")
    public User updateUser(@RequestBody User theUser) {

        userService.save(theUser);

        return theUser;
    }

    // add mapping for DELETE /users/{userId} - delete user

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable Long userId) {

        User tempUser = userService.findById(userId);

        // throw exception if null

        if (tempUser == null) {
            throw new RuntimeException("User id not found - " + userId);
        }

        userService.deleteById(userId);

        return "Deleted user id - " + userId;
    }

}