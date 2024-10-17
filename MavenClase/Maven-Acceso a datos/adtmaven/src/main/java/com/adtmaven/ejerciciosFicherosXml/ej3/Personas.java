package com.adtmaven.ejerciciosFicherosXml.ej3;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Personas {
    private ArrayList<Persona> personas;

    public Personas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public Personas(){}

    @XmlElementWrapper(name = "Personas")
    @XmlElement(name = "persona")
    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList <Persona> personas){
        this.personas = personas;
    }

}
