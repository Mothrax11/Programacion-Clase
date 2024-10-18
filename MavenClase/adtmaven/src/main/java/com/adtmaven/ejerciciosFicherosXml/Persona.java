package com.adtmaven.ejerciciosFicherosXml;
import java.io.Serializable;
public class Persona implements Serializable{

    private String nombre;
    private String dni;
    private String tlfno;
    private int edad;

    public Persona (String  nombre, String dni, String tlfno, int edad) {

        this.nombre  = nombre;
        this.dni = dni;
        this.tlfno = tlfno;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTlfno() {
        return tlfno;
    }

    public void setTlfno(String tlfno) {
        this.tlfno = tlfno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    
}
