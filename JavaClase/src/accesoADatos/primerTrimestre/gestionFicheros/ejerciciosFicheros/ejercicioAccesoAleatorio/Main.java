package accesoADatos.gestionFicheros.ejerciciosFicheros.ejercicioAccesoAleatorio;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        mostrarFichero();
        Scanner sc = new Scanner(System.in);
        System.out.printf("Introduce un numero entero: ");
        int entero = sc.nextInt();
        System.out.printf("Introduce la posicion en la que los quieres escribir: ");
        int pos = sc.nextInt();
        escribirDatosPos(pos, entero);
        mostrarFichero();
    }

    

    public static void escribirDatosPos(int pos, int num) {
        File fich = new File("JavaClase\\src\\accesoADatos\\gestionFicheros\\ejerciciosFicheros\\ejercicioAccesoAleatorio\\enteros.dat");
        try {

            RandomAccessFile ram = new RandomAccessFile(fich, "rw");
            ram.seek(2*(pos - 1) );
            ram.writeInt(num);
            ram.close();

        }catch(
        IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void mostrarFichero(){
        
        File fich = new File("JavaClase\\src\\accesoADatos\\gestionFicheros\\ejerciciosFicheros\\ejercicioAccesoAleatorio\\enteros.dat");

        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(fich));
            int k;
            while ((k = dis.readInt()) != -1){
                System.out.println(k);
            }
            dis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
