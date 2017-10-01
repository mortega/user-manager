package com.ortega.usermanager.domain.repository;

import com.ortega.usermanager.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by marcela on 9/30/17.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByCpf(String cpf);

}

