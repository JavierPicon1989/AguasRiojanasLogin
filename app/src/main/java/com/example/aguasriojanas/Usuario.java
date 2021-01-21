package com.example.aguasriojanas;

public class Usuario {
//Constrctor de la clase
        String email,nombre;

        public Usuario(String email, String nombre) {
            this.email = email;
            this.nombre = nombre;
        }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
