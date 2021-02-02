package com.example.aguasriojanas;

public class Usuario {

        String email,nombre;
        Integer id_usuario;

    public Usuario(String email, String nombre, Integer id_usuario) {
        this.email = email;
        this.nombre = nombre;
        this.id_usuario = id_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", nombre='" + nombre + '\'' +
                ", id_usuario=" + id_usuario +
                '}';
    }
}
