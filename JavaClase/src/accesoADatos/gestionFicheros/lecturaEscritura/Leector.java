package accesoADatos.gestionFicheros.lecturaEscritura;
import java.io.FileReader;


public class Leector {
    
    public static void main(String[] args) {
        try {
            int k;
            FileReader fr = new FileReader("src\\accesoADatos\\gestionFicheros\\lecturaEscritura\\ficheroPruebaLectura.txt"); 
            while ((k = fr.read()) != -1) {
                System.out.print((char)k);
            }
            fr.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
}
