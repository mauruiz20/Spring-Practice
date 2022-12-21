package com.spring.crudtemplate.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "clientes")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCliente")
    private int IdCliente;

    @Column(name = "Apellidos") @NonNull
    private String Apellidos;

    @Column(name = "Nombres") @NonNull
    private String Nombres;

    @Column(name = "Email") @NonNull
    private String Email;

    @Column(name = "Telefono") @NonNull
    private String Telefono;

    @Column(name = "Direccion") @NonNull
    private String Direccion;

    @Column(name = "Nacimiento") @NonNull
    private String Nacimiento;

    @Column(name = "Nacionalidad") @NonNull
    private String Nacionalidad;

    @Column(name = "Estadocliente") @NonNull
    private char EstadoCliente;

    public Clientes() {
    }

    public Clientes(String apellidos, String nombres, String email, String telefono, String direccion, String nacimiento, String nacionalidad) {
        Apellidos = apellidos;
        Nombres = nombres;
        Email = email;
        Telefono = telefono;
        Direccion = direccion;
        Nacimiento = nacimiento;
        Nacionalidad = nacionalidad;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int idCliente) {
        IdCliente = idCliente;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getNacimiento() {
        return Nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        Nacimiento = nacimiento;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        Nacionalidad = nacionalidad;
    }

    public char getEstadoCliente() {
        return EstadoCliente;
    }

    public void setEstadoCliente(char estadoCliente) {
        EstadoCliente = estadoCliente;
    }
}
