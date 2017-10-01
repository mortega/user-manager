package com.ortega.usermanager.controller;

import com.ortega.usermanager.UserService;
import com.ortega.usermanager.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by marcela on 9/30/17.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping()
    public Iterable<User> list(){
        return userService.list();
    }

    @PostMapping
    public User create(@RequestBody User user){
        return userService.insert(user);
    }

    @GetMapping("/{id}")
    public User read(@PathVariable("id") Long id) {
        return userService.get(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable("id") Long id, @RequestBody User user){
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        userService.remove(id);
    }

}
