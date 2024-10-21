package com.adtmaven.ejerciciosFicherosXml.ej3;

import java.util.ArrayList;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.*;

import com.adtmaven.primerEjercicio.ejercicioLibros.Libreria;
import com.adtmaven.primerEjercicio.ejercicioLibros.Libro;

public class Main {
    public static void main(String[] args) {
        JAXBContext context;
        Personas ps = new Personas();
    }



    public static void rellenarPersonas(){

        ArrayList<com.adtmaven.ejerciciosFicherosXml.Persona> personas = new ArrayList<>();
        File fich = new File("adtmaven\\src\\main\\java\\com\\adtmaven\\ejerciciosFicherosXml\\FichPersona.dat");
        try {
            FileInputStream fis = new FileInputStream(fich);
            try {
                ObjectInputStream ois = new ObjectInputStream(fis);
                try {
                    while (true) {
                        personas.add((com.adtmaven.ejerciciosFicherosXml.Persona)(ois.readObject()));
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    ois.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static transformar(ArrayList<com.adtmaven.ejerciciosFicherosXml.Persona> personas){

        ArrayList<Persona> personas3 = new ArrayList<>();

        for(com.adtmaven.ejerciciosFicherosXml.Persona p : personas){
            personas3.add(new Persona(p.getNombre(), p.getDni(), p.getTlfno(), p.getEdad()));
        }
        return personas3;
    }
}
