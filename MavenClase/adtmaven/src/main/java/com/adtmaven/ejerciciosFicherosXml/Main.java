package com.adtmaven.ejerciciosFicherosXml;
import java.util.ArrayList;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Personas", null);
            document.setXmlVersion("1.0");
            //crearXML(document);
            
            Persona p1 = new Persona("Raul", "58449745Y", "+34635837652", 20);
            Persona p2 = new Persona("Iyan", "18956121J", "+34635784521", 21);
            Persona p3 = new Persona("Pelayo", "87853215K", "+34631295754", 22);
            Persona p4 = new Persona("Daniel", "97663132X", "+34635648259", 23);
            ArrayList<Persona> personasLeer = new ArrayList<>();
            ArrayList<Persona> personasEscribir = new ArrayList<>();
            personasLeer.add(p1);
            personasLeer.add(p2);
            personasLeer.add(p3);
            personasLeer.add(p4);
            
            writeOnFile(personasLeer);
            leer(personasLeer, personasEscribir);
            crearXML(document, personasEscribir);
            leerXml(builder);
            

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void writeOnFile(ArrayList<Persona> personasLeer){
        File fich = new File("adtmaven\\src\\main\\java\\com\\adtmaven\\ejerciciosFicherosXml\\FichPersona.dat");
        
        try {
            FileOutputStream fos = new FileOutputStream(fich);
            try {
                ObjectOutputStream oos = new ObjectOutputStream(fos);    
                for (int i = 0; i < personasLeer.size(); i++) {
                    oos.writeObject(personasLeer.get(i));
                }
            oos.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void leer(ArrayList <Persona> personasLeer, ArrayList<Persona> personasEscribir){
        File fich = new File("adtmaven\\src\\main\\java\\com\\adtmaven\\ejerciciosFicherosXml\\FichPersona.dat");

        try {
            FileInputStream fis = new FileInputStream(fich);
            try {
                ObjectInputStream ois = new ObjectInputStream(fis);
                    try {
                        while (true) {
                            personasEscribir.add((Persona)(ois.readObject()));
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
    
    public static void crearXML(Document document,ArrayList<Persona> personasEscribir){

        document.setXmlVersion("1.0");
        
        for(int i = 0; i < personasEscribir.size(); i++){
            Element ele = document.createElement("persona");
            document.getDocumentElement().appendChild(ele);
            crearElemento("nombre", personasEscribir.get(i).getNombre(), ele, document);
            crearElemento("dni", personasEscribir.get(i).getDni(), ele, document);
            crearElemento("telefono", personasEscribir.get(i).getTlfno(), ele, document);
            crearElemento("edad", String.valueOf(personasEscribir.get(i).getEdad()), ele, document);
        }

        Source  source = new DOMSource(document);
        Result  result = new StreamResult(new File("adtmaven\\src\\main\\java\\com\\adtmaven\\ejerciciosFicherosXml", "personas.xml"));
        Result  sout = new StreamResult(System.out);

        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            transformer.transform(source, sout);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    public static void leerXml(DocumentBuilder builder){
        try {
            Document doc = builder.parse(new File("adtmaven\\src\\main\\java\\com\\adtmaven\\ejerciciosFicherosXml",  "personas.xml"));

            System.out.println(doc.getDocumentElement().getNodeName());
            NodeList lista = doc.getElementsByTagName("persona");

            for (int i = 0; i < lista.getLength(); i++) {
                Node node = lista.item(i);
                if (Node.ELEMENT_NODE == node.getNodeType()) {
                    Element ele = (Element) node;
                    System.out.println(ele.getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println(ele.getElementsByTagName("dni").item(0).getTextContent());
                    System.out.println(ele.getElementsByTagName("telefono").item(0).getTextContent());
                    System.out.println(ele.getElementsByTagName("edad").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void crearElemento(String datoEmple, String valor, Element ele, Document document){
        Element element = document.createElement(datoEmple);
        Text texto = document.createTextNode(valor);
        ele.appendChild(element);
        element.appendChild(texto);
    }
}
