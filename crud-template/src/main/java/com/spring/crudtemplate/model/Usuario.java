package com.spring.crudtemplate.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsuario")
    private int IdUsuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="IdRol")
    private Rol Rol;

    @Column(name = "Apellidos") @NonNull
    private String Apellidos;

    @Column(name = "Nombres") @NonNull
    private String Nombres;

    @Column(name = "Email", unique = true) @NonNull
    private String Email;

    @Column(name = "Direccion") @NonNull
    private String Direccion;

    @Column(name = "Nacimiento") @NonNull
    private String Nacimiento;

    @Column(name = "Clave") @NonNull
    private String Clave;

    @Column(name = "EstadoUsuario") @NonNull
    private char EstadoUsuario;

    public Usuario() {
    }

    public Usuario(int idUsuario, Rol rol, @NonNull String apellidos, @NonNull String nombres, @NonNull String email, @NonNull String direccion, @NonNull String nacimiento, @NonNull String clave) {
        IdUsuario = idUsuario;
        Rol = rol;
        Apellidos = apellidos;
        Nombres = nombres;
        Email = email;
        Direccion = direccion;
        Nacimiento = nacimiento;
        Clave = clave;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }

    @NonNull
    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(@NonNull String apellidos) {
        Apellidos = apellidos;
    }

    @NonNull
    public String getNombres() {
        return Nombres;
    }

    public void setNombres(@NonNull String nombres) {
        Nombres = nombres;
    }

    @NonNull
    public String getEmail() {
        return Email;
    }

    public void setEmail(@NonNull String email) {
        Email = email;
    }

    @NonNull
    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(@NonNull String direccion) {
        Direccion = direccion;
    }

    @NonNull
    public String getNacimiento() {
        return Nacimiento;
    }

    public void setNacimiento(@NonNull String nacimiento) {
        Nacimiento = nacimiento;
    }

    @NonNull
    public String getClave() {
        return Clave;
    }

    public void setClave(@NonNull String clave) {
        Clave = clave;
    }

    public char getEstadoUsuario() {
        return EstadoUsuario;
    }

    public void setEstadoUsuario(char estadoUsuario) {
        EstadoUsuario = estadoUsuario;
    }

    public Rol getRol() {
        return Rol;
    }

    public void setRol(Rol rol) {
        Rol = rol;
    }
}
