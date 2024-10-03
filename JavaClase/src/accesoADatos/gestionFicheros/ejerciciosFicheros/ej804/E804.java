package accesoADatos.gestionFicheros.ejerciciosFicheros.ej804;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class E804 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String rutaArchivo = sc.nextLine();
        String nombreArchivo =  sc.nextLine();
        File fich = new File (rutaArchivo, nombreArchivo);

        try {
            int numPalabras = 0;
            int numLineas = 0;
            int numCaracteres = 0;
            int k;
            FileReader fr = new FileReader(fich);
            BufferedReader br =new BufferedReader(fr);
        
            while((k = br.read()) != -1) {
                    numCaracteres++;
                    if(k == 32){
                        numPalabras++;
                    }
            }

            while (br.lines() != null){
                numLineas++;
            }
            System.out.println("Número de Caracteres: " + numCaracteres);
            System.out.println("Número de Palabras: " + numPalabras);

            System.out.println("Número de Líneas: " + numLineas);


        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

