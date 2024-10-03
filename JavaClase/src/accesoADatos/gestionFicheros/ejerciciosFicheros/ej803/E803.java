package accesoADatos.gestionFicheros.ejerciciosFicheros.ej803;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class E803 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Ruta del archivo origen: ");
        String rutaArchivoOrigen = sc.nextLine();
        System.out.println("Nombre del archivo origen: ");
        String nombreArchivoOrigen =  sc.nextLine();
        File fich = new File (rutaArchivoOrigen, nombreArchivoOrigen);

        System.out.println("Ruta del archivo destino: ");
        String rutaArchivoDestino = sc.nextLine();
        System.out.println("Nombre del archivo detino: ");
        String nombreArchivoDestino =  sc.nextLine();
        File dupe = new File (rutaArchivoDestino, nombreArchivoDestino);


        try {
            FileReader fr = new FileReader(fich);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(dupe, true);
            BufferedWriter bw = new BufferedWriter(fw);
            int k;
            int count = 0;

            while ((k = br.read()) != -1){
                bw.write(k);
                count++;
            }
            System.out.println("Número de caracteres grabados: " + count);
            br.close();
            bw.close();
            fr.close();
            fw.close();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
