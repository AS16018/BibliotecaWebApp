package ues.occ.edu.sv.tpi135.bibliotecawebapp.entity;

import java.util.List;

public class Login {
    String correo;
    String password;

    public Login(){
    }

    public Login(String correo, String password){
        this.correo = correo;
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
   
}