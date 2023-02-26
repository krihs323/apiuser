package com.nisum.apiuser.controller;


import com.nisum.apiuser.domain.ErrorDTO;
import com.nisum.apiuser.domain.RespuestaDTO;
import com.nisum.apiuser.domain.UserDTO;
import com.nisum.apiuser.persistence.model.User;
import com.nisum.apiuser.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    UserService userService;

    @PostMapping()
    public ResponseEntity<?> save(@Valid @RequestBody UserDTO userDTO, BindingResult bindingResult) {

        Map<String, Object> respuestaDummy = new HashMap<>();
        ErrorDTO error = new ErrorDTO();
        if (bindingResult.hasErrors()){
            error.setMensaje( bindingResult.getFieldError().getField() + ": " + bindingResult.getFieldError().getDefaultMessage());
            return new ResponseEntity<ErrorDTO>(error, HttpStatus.BAD_REQUEST);
        }

        //Search by email before save
        List<User> userEmail = userService.findByEmail(userDTO.getEmail());
        if(userEmail.size()>0){
            error.setMensaje("El correo ya fue registrado");
            return new ResponseEntity<ErrorDTO>(error, HttpStatus.BAD_REQUEST);
        }

        RespuestaDTO respuesta;
        respuesta = userService.save(userDTO);




        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);

    }
}
