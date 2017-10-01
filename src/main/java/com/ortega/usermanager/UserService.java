package com.ortega.usermanager;

import com.ortega.usermanager.domain.entity.User;
import com.ortega.usermanager.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public User get(Long id){
        return repository.findOne(id);
    }

    public User update(Long id, User user) {
        User currentUser = repository.findOne(id);
        if(currentUser == null) return null;

        user.setId(id);
        return repository.save(user);
    }

    public void remove(Long id) {
        repository.delete(id);
    }

    public User search(String cpf) {
        return repository.findByCpf(cpf);
    }

}
