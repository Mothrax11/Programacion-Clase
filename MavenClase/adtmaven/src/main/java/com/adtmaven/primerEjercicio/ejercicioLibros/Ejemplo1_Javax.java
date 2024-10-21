package com.adtmaven.primerEjercicio.ejercicioLibros;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Ejemplo1_Javax {
    public static void main(String[] args) {
        JAXBContext context;
        Libreria lib = new Libreria();
        rellenarLibreria(lib);

        try {
            context = JAXBContext.newInstance(Libreria.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(lib, System.out);
            m.marshal(lib, new File("adtmaven\\src\\main\\java\\com\\adtmaven\\ejercicioLibros\\libreria.xml"));
        } catch (Exception e) {
            
        }
    }

    public static void rellenarLibreria(Libreria libreria){
        Libro lib1 = new Libro("Las aventuras de Pelayo", "Pelayo",  "Editorial Pelayo", "1111");
        Libro lib2 = new Libro("Las aventuras de Iyán", "Iyán",  "Editorial Iyán", "1112");
        Libro lib3 = new Libro("Las aventuras de Dani", "Dani",  "Editorial Dani", "1113");
        Libro lib4 = new Libro("Las aventuras de Raul", "Raul",  "Editorial Raul", "1114");

        ArrayList<Libro> listaTemporal = new ArrayList<>();
        listaTemporal.add(lib1);
        listaTemporal.add(lib2);
        listaTemporal.add(lib3);
        listaTemporal.add(lib4);
        libreria.setListaLibros(listaTemporal);

    }
}
