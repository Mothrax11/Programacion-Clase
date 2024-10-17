package accesoADatos.pruebaInicial.archivos.notificaciones;

import accesoADatos.pruebaInicial.archivos.ConstructorFecha;

public class Notificacion {
    private long id;
    private String fecha;
    private String mensaje;
    private int dia;
    private int mes;
    private int ano;

    public Notificacion notificacion (long id, String fecha, String mensaje){
        return notificacion(id, fecha, mensaje);
    }


    public String convertirFecha(int dia, int mes, int ano){
        return ConstructorFecha.conversorFecha(dia, mes, ano);
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
