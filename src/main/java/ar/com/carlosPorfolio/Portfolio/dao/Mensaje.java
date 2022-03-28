package ar.com.carlosPorfolio.Portfolio.dao;

public class Mensaje {

    private String mensaje;

    //terminar la implementacion para los mensajes de error si hay tiempo de otro modo queda sin uso

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
