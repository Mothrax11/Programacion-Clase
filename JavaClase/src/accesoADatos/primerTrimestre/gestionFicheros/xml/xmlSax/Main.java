package accesoADatos.gestionFicheros.xml.xmlSax;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class Main {
    public static void main(String[] args) {
        leerDocumento();
    }    

    public static void leerDocumento(){
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        try {
           
            SAXParser parser = parserFactory.newSAXParser();
            XMLReader procesadorXML = parser.getXMLReader();
            InputSource input = new InputSource("JavaClase\\src\\accesoADatos\\gestionFicheros\\xml\\xmlParsear\\empleados.xml");
            procesadorXML.parse(input);

            GestorContenido gc = new GestorContenido();
            procesadorXML.setContentHandler(gc);
            InputSource inputGC = new InputSource("JavaClase\\src\\accesoADatos\\gestionFicheros\\xml\\xmlParsear\\empleados.xml");
            procesadorXML.parse(inputGC);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
