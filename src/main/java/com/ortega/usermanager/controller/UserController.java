package com.ortega.usermanager.controller;

import com.ortega.usermanager.UserService;
import com.ortega.usermanager.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;

import javax.validation.Valid;
import java.util.List;

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
    public User create(@RequestBody @Valid User user){
        return userService.insert(user);
    }

    @GetMapping("/{id}")
    public User read(@PathVariable("id") Long id) {
        return userService.get(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable("id") Long id, @RequestBody @Valid User user){
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        userService.remove(id);
    }

    @GetMapping("/cpf/{cpf}")
    public User searchByCpf(@PathVariable("cpf") String cpf){
        return userService.search(cpf);
    }

    @PostMapping("/batch")
    public Iterable<User> createAll(@RequestBody List<User> users){
        return userService.insertAll(users);
    }
}
