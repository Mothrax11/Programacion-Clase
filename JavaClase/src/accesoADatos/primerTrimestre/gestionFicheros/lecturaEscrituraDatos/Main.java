package accesoADatos.gestionFicheros.lecturaEscrituraDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;

public class Main {
 // fichero 0-99 de datos, crear y leer.
    public static void main(String[] args) {
        File fichero = new File("pruebaDatos.dat");
        crearEscribir(fichero);
        leer(fichero);
    }

    private static void crearEscribir(File f){
        
                try {
                    

                    FileOutputStream fich;
                    fich = new FileOutputStream(f);
                    DataOutputStream dfich = new DataOutputStream(fich);

                    String cadena[] = {
                            "Carlos", "María", "José", "Ana", "Luis", "Marta", "Pablo", "Laura", "Antonio", "Isabel",
                            "Javier", "Sofía", "Miguel", "Elena", "Fernando", "Lucía", "Manuel", "Carmen", "Raúl",
                            "Patricia", "Pedro", "Sara", "David", "Silvia", "Andrés", "Beatriz", "Diego", "Rosa", "Sergio", "Clara"
                    };

                    int numeros[] = {
                            45, 78, 12, 93, 56, 34, 67, 89, 23, 11,
                            49, 92, 5, 64, 38, 17, 83, 29, 50, 73,
                            22, 66, 7, 81, 41, 99, 27, 6, 53, 31
                    };
                    
                    for (int i = 0; i <= numeros.length - 1; i++){
                        try {
                            dfich.writeUTF(cadena[i]);
                            dfich.writeInt(numeros[i]);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                     
                        
                    }
                    
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }       
    }

    private static void leer(File f){
         try {
             while (true) {
                 try {
                     FileInputStream fis = new FileInputStream(f);
                     DataInputStream dis = new DataInputStream(fis);
                     System.out.println("Nombre: " + dis.readUTF()  + " Edad: " + dis.readInt());
                 } catch (EOFException e) {
                     System.out.println(e.getMessage());

                 }

             }
         } catch (Exception e) {
            
         }
            

    }




    
}
