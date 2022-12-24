package com.spring.crudtemplate.security;

public class AuthCredentials {
    private String Email;
    private String Clave;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }
}
