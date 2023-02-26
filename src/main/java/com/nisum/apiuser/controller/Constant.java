package com.nisum.apiuser.controller;

public class Constant {

    public static final String EXPMESSAGE = "Debe incluir al menos un número al menos una letra minúscula al menos una letra mayúscula y al menos un carácter especial con loongitud de 8 a 18 carácteres";
    public static final String EXPRESSION = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$^&*()_-]).{8,18}$";
}
