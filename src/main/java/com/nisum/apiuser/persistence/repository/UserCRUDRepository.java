package com.nisum.apiuser.persistence.repository;

import com.nisum.apiuser.persistence.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserCRUDRepository extends CrudRepository<User, Long> {

    List<User> findByEmail(String email);


}
