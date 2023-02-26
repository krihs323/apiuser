package com.nisum.apiuser.persistence.repository;

import com.nisum.apiuser.persistence.model.Phone;

import java.util.List;

public interface IPhone {

    Phone save(Phone phone);

    void saveAll(List<Phone> phones);

}
