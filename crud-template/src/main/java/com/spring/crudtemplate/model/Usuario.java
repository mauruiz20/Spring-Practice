package com.spring.crudtemplate.model;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsuario")
    private int idUsuario;

    @Column(name = "IdRol")
    private int idRol;

    @Column(name = "Apellidos")
    private String apellidos;

    @Column(name = "Nombres")
    private String nombres;

    @Column(name = "Email")
    private String email;

    @Column(name = "Direccion")
    private String direccion;

    @Column(name = "Nacimiento")
    private String nacimiento;

    @Column(name = "Clave")
    private String clave;

    @Column(name = "EstadoUsuario")
    private String estadoUsuario;

}
