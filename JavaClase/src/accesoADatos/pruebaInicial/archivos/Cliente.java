package accesoADatos.pruebaInicial.archivos;
import java.util.Scanner;
import java.util.ArrayList;

import accesoADatos.pruebaInicial.archivos.documentaciones.Documentacion;
import accesoADatos.pruebaInicial.archivos.documentaciones.Nie;
import accesoADatos.pruebaInicial.archivos.documentaciones.Nif;
import accesoADatos.pruebaInicial.archivos.notificaciones.Notificacion;
import accesoADatos.pruebaInicial.archivos.notificaciones.NotificacionEMail;

public class Cliente {
    private Documentacion id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String fechaNac;
    private boolean suscripcion;
    private char pagoPref;
    private int dia;
    private int mes;
    private int ano;
    private ArrayList<Notificacion> notificaciones;
    
    public Cliente (Documentacion id, String nombre, String direccion, String telefono, int dia, int mes, int ano, char pagoPref){

        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.pagoPref = pagoPref;
        this.suscripcion = false;
        notificaciones = new ArrayList<>();

    }


    public static Cliente newCliente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("NIF (1) o NIE (2)");
        int eleccionDocumento = sc.nextInt();
        Documentacion doku = null;
        

        if (eleccionDocumento == 1){
            System.out.println("Introduzca los numeros del NIF");
            int numerosNif = -1;
            
                numerosNif = sc.nextInt();

                while (Integer.toString(numerosNif).length() != 8) {
                    System.out.println("Introduzca 8 digitos");
                    numerosNif = sc.nextInt();
                }

            
            System.out.println("Introduzca la letra del NIF");
            String letraNif = sc.next();
            letraNif = letraNif.toUpperCase();

            while (letraNif.length() != 1 ){
                System.out.println("Introduzca solo 1 unico valor, cuidando las mayúsculas.");
                letraNif = sc.next();
            }

            doku = new Nif(letraNif, numerosNif);
        } else if (eleccionDocumento == 2){
            try {

                System.out.println("Introduzca letra inicial del NIE");
                String inputLetras = sc.next();
                char letraInicial = ' ';
                
                while (inputLetras.length() != 1 || (inputLetras.charAt(0) != 'X') && (inputLetras.charAt(0) != 'Y') && (inputLetras.charAt(0) != 'Z')){
                    System.out.println("Introduzca solo 1 unico valor (Solo se aceptan los valores \"X\", \"Y\" & \"Z\").");
                    inputLetras = sc.next();
                }
                
                letraInicial = inputLetras.charAt(0);
                System.out.println("Introduzca los numeros del NIE");
                int numerosNie = sc.nextInt();

                while (Integer.toString(numerosNie).length() != 7) {
                    System.out.println("Introduzca 7 digitos");
                    numerosNie = sc.nextInt();
                }

                System.out.println("Introduzca letra final del NIE");

                char letraFinalNie = sc.next().charAt(0);
                doku = new Nie(numerosNie, letraInicial, letraFinalNie);
            } catch (Exception e) {
                
            }
            
           
        } else {
            System.out.println("Eleccion no valida");
        }

        System.out.println("¿Que tipo de pago prefiere?");
        System.out.println("E (Efectivo) | T (Transferencia) |  C (Tarjeta)");
        char pagoPref = sc.next().charAt(0);

        System.out.println("Nombre: ");
        String nombre = sc.next();
        System.out.println("Direccion: ");
        String direccion = sc.next();
        System.out.println("Telefono: ");
        String telefono = sc.next();

        System.out.println("Dia de nacimiento en numero: ");
        int dia = sc.nextInt();

        System.out.println("Mes de nacimiento en numero: ");
        int mes = sc.nextInt();

        System.out.println("Año de nacimiento en numero: ");
        int ano = sc.nextInt();

        boolean suscripcion = false;
        String estadoSuscripcion;
        if (suscripcion){
            estadoSuscripcion = "Suscrito";
        } else {
            estadoSuscripcion = "No suscrito";
        }

        enum tipoPago {
            EFECTIVO, TRANSFERENCIA, TARJETA
        }

        tipoPago pagoElegido;
        if(pagoPref == 'E'||pagoPref == 'e'){
            pagoElegido = tipoPago.EFECTIVO;
        } else if (pagoPref == 'T' || pagoPref == 't'){
            pagoElegido = tipoPago.TRANSFERENCIA;
        } else if (pagoPref == 'C' || pagoPref == 'c'){
            pagoElegido = tipoPago.TARJETA;
        } else {
            pagoElegido = null;
        }

        System.out.println("El usuario ha sido creado con los siguientes campos \n");
        System.out.println("Nombre: " + nombre);
        System.out.println("Documentacion: " + doku.toString());
        System.out.println("Direccion: " + direccion);
        System.out.println("Número de teléfono: " + telefono);
        System.out.println("Fecha de nacimiento: " + ConstructorFecha.conversorFecha(dia, mes, ano));
        System.out.println("Estado de la suscripción: " + estadoSuscripcion);
        System.out.println("Pago establecido: " + pagoElegido );
        
        return new Cliente(doku, nombre, direccion, telefono, dia, mes, ano, pagoPref);
    }

    public void anadirNotificacion (long id, int dia, int mes, int ano, String direccion){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Por donde va a enviar la notificacion?");
        System.out.println("Email (1) | Teléfono (2)");
        int via = sc.nextInt();

        if (via == 1){
            Notificacion notificacionEmail = new NotificacionEMail();
        } else if (via == 2){
            Notificacion notificacionTel = new Notificacion();
        }
        
    }

    public Documentacion getId() {
        return id;
    }

    public void setId(Documentacion id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNac() {
       return fechaNac;
    }

    public void setFechaNac(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public boolean isSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(boolean suscripcion) {
        this.suscripcion = suscripcion;
    }

    public char getPagoPref() {
        return pagoPref;
    }

    public void setPagoPref(char pagoPref) {
        this.pagoPref = pagoPref;
    } 
    
}
