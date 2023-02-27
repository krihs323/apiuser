package com.nisum.apiuser.controller;


import com.nisum.apiuser.domain.ErrorDTO;
import com.nisum.apiuser.domain.RespuestaDTO;
import com.nisum.apiuser.domain.UserDTO;
import com.nisum.apiuser.persistence.model.User;
import com.nisum.apiuser.service.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
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

    @Operation(summary = "Recurso se realiza el guardado del usuario en la base de datos", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content) })
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
