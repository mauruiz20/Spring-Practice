package com.spring.crudtemplate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor

@Entity
@Table(name = "Roles")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdRol")
    private int IdRol;

    @Column(name = "Rol")
    private String Rol;
}
