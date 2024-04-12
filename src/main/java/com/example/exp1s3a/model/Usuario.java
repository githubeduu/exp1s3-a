package com.example.exp1s3a.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
@Table(name = "usuario")
public class Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Nonnull
    @Column(name = "nombre")
    private String nombre;

    @Nonnull
    @Column(name = "contrasena")
    private String contrasena;

    @Nonnull
    @Column(name = "rut")
    private String rut;

    @Nonnull
    @Column(name = "direccion")
    private String direccion;

    @Nonnull
    @Column(name = "rol")
    private Roles rol;

    //getters
    public Long getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public String getContrasena(){
        return contrasena;
    }

    public String getRut(){
        return rut;
    }

    public String getDireccion(){
        return direccion;
    }

    public Roles getRoles(){
        return rol;
    }


    //setters
    public void setId(Long id){
        this.id = id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    }

    public void setRut(String rut){
        this.rut = rut;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public void setRol(Roles rol){
        this.rol = rol;
    }
}

