package com.example.exp1s3a;

public class Roles{
    private int id;
    private String rol;

    public Roles(int id, String rol){
        this.id = id;
        this.rol = rol;
    }

    public int getId(){
        return id;
    }

    public String getRol(){
        return rol;
    }
}