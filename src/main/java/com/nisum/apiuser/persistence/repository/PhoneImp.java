package com.nisum.apiuser.persistence.repository;

import com.nisum.apiuser.persistence.model.Phone;
import com.nisum.apiuser.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhoneImp implements IPhone{

    @Autowired
    private PhoneCRUDRepository phoneCRUDRepository;
    @Override
    public Phone save(Phone phone) {
        //Se guardar el objeto del nuevo usuario
        phoneCRUDRepository.save(phone);
        return phone;
    }

    @Override
    public void saveAll(List<Phone> phones) {
        phoneCRUDRepository.saveAll(phones);
    }
}
