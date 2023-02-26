package com.nisum.apiuser.persistence.repository;

import com.nisum.apiuser.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserImp implements IUser {

    @Autowired
    private UserCRUDRepository userCRUDRepository;

    @Override
    public User save(User user) {
        //Se guardar el objeto del nuevo usuario
        User userNew = userCRUDRepository.save(user);

        //Se retorna nuevo usuario
        return userNew;
    }

    @Override
    public List<User> findByEmail(String email) {
        //Se realiza la busqueda por medio del email
        List<User> users = userCRUDRepository.findByEmail(email);
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {

        //Se realiza la busqueda por medio del id
        Optional<User> user = userCRUDRepository.findById(id);
        return user;
    }
}
