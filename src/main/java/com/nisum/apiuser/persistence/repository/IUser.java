package com.nisum.apiuser.persistence.repository;

import com.nisum.apiuser.persistence.model.User;

import java.util.List;
import java.util.Optional;

public interface IUser {

    User save(User user);

    List<User> findByEmail(String email);

    Optional<User> findById(Long id);
}
