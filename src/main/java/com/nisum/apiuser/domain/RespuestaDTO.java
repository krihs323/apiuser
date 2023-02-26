package com.nisum.apiuser.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaDTO {

    private String id;

    private Date created;

    private Date modified;

    private Date lastLogin;

    private String token;

    private boolean isActive;

}
