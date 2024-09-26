package accesoADatos.gestionFicheros.importarObjetos;

import java.io.Serializable;

public class Persona implements Serializable {
    
    private int edad;
    private String nombre;
    private String  apellidos;

    public Persona(int edad, String nombre, String apellidos){

        this.edad = edad;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" + "Apellidos:  "+ apellidos + "\n" + "Edad : " + edad;

    }
    
}
