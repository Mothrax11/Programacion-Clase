package com.adtmaven.ejerciciosFicherosXml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class Ej2 extends DefaultHandler {
    String nombre;
    String dni;
    String tlfno;
    int edad;
    public static void main(String[] args) {
        leerDocumento();
    }

    public static void leerDocumento(){
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = parserFactory.newSAXParser();
            XMLReader procesadorXML = parser.getXMLReader();
            InputSource input = new InputSource("adtmaven\\src\\main\\java\\com\\adtmaven\\ejerciciosFicherosXml\\personas.xml");
            procesadorXML.parse(input);

            Ej2 gc = new Ej2();
            procesadorXML.setContentHandler(gc);
            InputSource inputGC = new InputSource("adtmaven\\src\\main\\java\\com\\adtmaven\\ejerciciosFicherosXml\\personas.xml");
            procesadorXML.parse(inputGC);
        } catch (Exception e){
            e.getMessage();
        }
    }

    public Ej2(){
        super();
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String cont = new String(ch, start, length);
        cont = cont.replaceAll("[\t\n]", "");
        if (!(cont.isEmpty())){
            System.out.printf("\t Contenido: %s %n", cont);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }
}
