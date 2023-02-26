package com.nisum.apiuser.service;

import com.nisum.apiuser.domain.RespuestaDTO;
import com.nisum.apiuser.domain.UserDTO;
import com.nisum.apiuser.persistence.model.Phone;
import com.nisum.apiuser.persistence.model.User;
import com.nisum.apiuser.persistence.repository.IPhone;
import com.nisum.apiuser.persistence.repository.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    IUser iUser;

    @Autowired
    IPhone iPhone;

    public RespuestaDTO save(UserDTO userDTO){

        //Se le realiza transformacion para guardar en la base de datos
        User user = new User();
        User newUser = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());



        //Setear las otras variables de creacion
        Date date = new Date();

        user.setUuid(UUID.randomUUID().toString());
        user.setCreated(date);
        user.setModified(date);
        user.setLastLogin(date);
        user.setToken(UUID.randomUUID().toString());
        user.setActive(true);

        newUser = iUser.save(user);

        RespuestaDTO respuestaDTO = new RespuestaDTO();
        respuestaDTO.setId(user.getUuid());
        respuestaDTO.setCreated(user.getCreated());
        respuestaDTO.setModified(user.getModified());
        respuestaDTO.setLastLogin(user.getLastLogin());
        respuestaDTO.setToken(user.getToken());
        respuestaDTO.setActive(user.isActive());

        //Guardar los telefonos
        List<Phone> phones = new ArrayList<Phone>();

        for (int i = 0; i < userDTO.getPhones().size(); i++) {
            Phone phone = new Phone();
            phone.setUser(newUser);
            phone.setNumber(userDTO.getPhones().get(i).getNumber());
            phone.setCityCode(userDTO.getPhones().get(i).getCityCode());
            phone.setContryCode(userDTO.getPhones().get(i).getContryCode());
            phones.add(phone);
        }

        iPhone.saveAll(phones);


        return respuestaDTO;
    }

    public List<User> findByEmail(String email){
        List<User> users = iUser.findByEmail(email);

        return users;
    }

}
