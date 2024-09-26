package accesoADatos.gestionFicheros.ejerciciosFicheros.ej1;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class e801 {
    public static void main(String[] args) {
        File fich = new File("src\\accesoADatos\\gestionFicheros\\ejerciciosFicheros\\ej1\\entrada801.dat");
        ArrayList <Integer> edades = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(fich);
            DataInputStream dis = new DataInputStream(fis);
            while (true) {
                 try {
                    System.out.println(dis.read());
    
                 } catch (EOFException e) {
                     System.out.println(e.getMessage());
                 }
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
