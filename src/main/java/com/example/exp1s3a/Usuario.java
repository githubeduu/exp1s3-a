package com.example.exp1s3a;

public class Usuario {
    private int id;
    private String nombre;
    private String contraseña;
    private String rut;
    private String direccion;
    private Roles rol;

    public Usuario(int id, String nombre, String contraseña, String rut, String direccion, Roles rol) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.rut = rut;
        this.direccion = direccion;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getRut() {
        return rut;
    }

    public String getDireccion() {
        return direccion;
    }

    public Roles getRol() {
        return rol;
    }
}