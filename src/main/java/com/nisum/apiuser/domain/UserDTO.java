package com.nisum.apiuser.domain;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.nisum.apiuser.controller.Constant.EXPMESSAGE;
import static com.nisum.apiuser.controller.Constant.EXPRESSION;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotBlank(message = "Es requerido")
    private String name;

    @NotEmpty(message = "Es requerido")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "El correo ingresado no tiene un formato correcto")
    private String email;

    @NotBlank(message = "Es requerido")
    @Pattern(regexp = EXPRESSION,  message = EXPMESSAGE)
    private String password;

    private List<PhoneDTO> phones;

}
