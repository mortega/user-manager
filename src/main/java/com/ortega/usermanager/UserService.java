package com.ortega.usermanager;

import com.ortega.usermanager.domain.entity.User;
import com.ortega.usermanager.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by marcela on 9/30/17.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Iterable<User> list() {
        return repository.findAll();
    }

    @Transactional
    public User insert(User user) {
        return repository.save(user);
    }

    public User get(Long id) throws ResourceNotFoundException {
        User currentUser = repository.findOne(id);
        if(currentUser == null) throw new ResourceNotFoundException("User not found.");
        return currentUser;
    }

    public User update(Long id, User user) {
        User currentUser = repository.findOne(id);
        if(currentUser == null) throw new ResourceNotFoundException("User not found.");
        user.setId(id);
        return repository.save(user);
    }

    public void remove(Long id) {
        try {
            repository.delete(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("User not found.");
        }
    }

    public User search(String cpf) {
        User currentUser = repository.findByCpf(cpf);
        if(currentUser == null) throw new ResourceNotFoundException("User not found.");
        return currentUser;
    }

    @Transactional
    public Iterable<User> insertAll(List<User> users) {
        return repository.save(users);
    }

}
