package modelo;

import java.io.Serializable;

public class Usuario implements Serializable {

        public  String email, nombre, password, id_usuario;

    public Usuario() {

    }

    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                ", id_usuario='" + id_usuario + '\'' +
                '}';
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Usuario(String email, String nombre, String password, String id_usuario) {
        this.email = email;
        this.nombre = nombre;
        this.password = password;
        this.id_usuario = id_usuario;
    }
}
