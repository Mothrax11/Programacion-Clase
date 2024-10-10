package accesoADatos.gestionFicheros.xml;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import  java.io.*;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Empleados", null);
            document.setXmlVersion("1.0"); // asignamos la versión de nuestro XML
            //crearXML(document);
            cargarXML(builder);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void crearXML(Document document){
        document.setXmlVersion("1.0");
        Element ele = document.createElement("empleado");
        document.getDocumentElement().appendChild(ele);

        System.out.println("Dame el apellido del empleado");
        String apellido =  sc.nextLine();
        crearElemento("apellido", apellido, ele, document);
        System.out.println("Dame el numero del empleado");
        int numero =  sc.nextInt();
        crearElemento("numero", Integer.toString(numero), ele, document);
        System.out.println("Dame el salario del empleado");
        float salario=  sc.nextFloat();
        crearElemento("salario", Float.toString(salario), ele, document);

        Source  source = new DOMSource(document );
        Result  result = new StreamResult(new File("JavaClase\\src\\accesoADatos\\gestionFicheros\\xml", "empleados.xml"));
        Result  sout = new StreamResult(System.out);

        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            transformer.transform(source, sout);
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }

    public static void cargarXML(DocumentBuilder builder){
       try {
            Document doc = builder.parse(new File("empleados.xml"));
            System.out.println(doc.getDocumentElement().getNodeName());
            NodeList lista = doc.getElementsByTagName("empleado");

            for(int i = 0; i < lista.getLength(); i++){
                Node node = lista.item(i);
                if(Node.ELEMENT_NODE  == node.getNodeType()){
                    Element ele = (Element)node;
                    System.out.println(ele.getElementsByTagName("numero").item(0).getTextContent());
                    System.out.println(ele.getElementsByTagName("apellido").item(0).getTextContent());
                    System.out.println(ele.getElementsByTagName("salario").item(0).getTextContent());
                }
            }
       } catch (Exception e) {
        
       }

    }

    public static void crearElemento(String datoEmple, String valor, Element ele, Document document){

        Element element = document.createElement(datoEmple);
        Text texto = document.createTextNode(valor);
        ele.appendChild(element);
        element.appendChild(texto);

    }
}
    

