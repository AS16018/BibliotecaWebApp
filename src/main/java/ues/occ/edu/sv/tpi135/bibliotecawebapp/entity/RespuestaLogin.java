package ues.occ.edu.sv.tpi135.bibliotecawebapp.entity;

public class RespuestaLogin {
    String mensaje;

    public RespuestaLogin(){
    }

    public RespuestaLogin( String mensaje){
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
