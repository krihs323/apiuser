package com.nisum.apiuser.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDTO {

    @Digits(integer = 10, fraction = 0, message = "Valor permitido hasta 10 dígitos")
    private long number;

    @Digits(integer = 2, fraction = 0, message = "Valor permitido hasta 2 dígitos")
    @JsonProperty("citycode")
    private int cityCode;

    @Digits(integer = 6, fraction = 0, message = "Valor permitido hasta 6 dígitos")
    @JsonProperty("contrycode")
    private int contryCode;
}
