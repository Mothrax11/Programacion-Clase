package accesoADatos.gestionFicheros.importarObjetos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File fich = new File(".", "objetosPersona.dat");
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el nombre: ");
        String nombre = sc.next();
        System.out.println("Escriba los apellido: ");
        String apellidos = sc.next();
        System.out.println("Escriba la edad: ");
        int edad = sc.nextInt();
        sc.close();

        Persona p1 = new Persona(edad, nombre, apellidos);
        writeObject(p1, fich);
        leerFichero(fich);

    }

    public static void writeObject(Object p1, File fich){
        
        try {
            ObjectOutputStream obou = new ObjectOutputStream(new FileOutputStream(fich));
            obou.writeObject(p1);
            obou.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void leerFichero(File fich){
        
        try {
            FileInputStream  fis = new FileInputStream(fich);
            ObjectInputStream ois = new ObjectInputStream(fis);
            System.out.println(ois.readObject());
            ois.close();

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
