package accesoADatos.gestionFicheros.ejerciciosFicheros.ej804;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class E804 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        //String rutaArchivo = sc.nextLine();
        //String nombreArchivo =  sc.nextLine();
        File fich = new File ("JavaClase\\src\\accesoADatos\\gestionFicheros\\ejerciciosFicheros\\ej804\\archivos", "e804.txt");

        try {
            int numPalabras = 1;
            int numLineas = 0;
            int numCaracteres = 0;
            int k;
            FileReader fr = new FileReader(fich);
            BufferedReader br =new BufferedReader(new FileReader(fich));
        
            while((k = fr.read()) != -1) {
                    numCaracteres++;
                    if(k == 32  || k == 10) {
                        numPalabras++;
                    }
            }

            
            while (br.readLine() != null){
                numLineas++;
            }

            
            fr.close();
            br.close();
            System.out.println("Número de Caracteres: " + numCaracteres);
            System.out.println("Número de Palabras: " + numPalabras);
            System.out.println("Número de Líneas: " + numLineas);


        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

