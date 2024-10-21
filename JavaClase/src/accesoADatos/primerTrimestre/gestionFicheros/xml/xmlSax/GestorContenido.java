package accesoADatos.gestionFicheros.xml.xmlSax;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class GestorContenido extends DefaultHandler {
    String nombre;
    int numero; 
    double salario;
    public int counter = 0;

    
    
    public GestorContenido() { 
        super();
    }

    @Override
    public void startDocument(){
        System.out.println("Comienzo del documento XML");
    }

    @Override
    public void  endDocument(){
        System.out.println("Fin del documento XML");
    }

    @Override
    public void startElement (String uri, String nombre, String nombrec, Attributes att){
        System.out.printf("\t Principio Elemento: %s %n", nombrec);
    }

    @Override
    public void endElement(String uri, String nombre, String nombreC) { 
          System.out.printf("\tFin Elemento: %s %n", nombreC);
    }

    @Override
    public void characters(char[] ch, int inicio, int longitud) throws SAXException { 
       String cont=new String(ch, inicio, longitud); 
       cont = cont.replaceAll("[\t\n]","");      
       System.out.printf ("\t Contenido: %s %n", cont);
        
       
      }
      
    

}
