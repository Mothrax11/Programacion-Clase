package accesoADatos.primerTrimestre.gestionFicheros.ejerciciosFicheros.eTrabajador;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Trabajadores {
    
    public static void main(String[] args) {
    
            char apellidoChar[] = new char[10];
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Quieres añadir un nuevo registro o leer uno ya existente? (1 nuevo | 2 leer): ");
            int choice =  sc.nextInt();
            if (choice == 1){
                System.out.println("Introduce el apellido del trabajador (no mas de 15 caracteres): ");
                String apellido = sc.next();

                if(apellido.length() <= 10){
                    try {
                        for (int i = 0; i < 10; i++) {
                            apellidoChar[i] = 'j';
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("El apellido introducido tiene mas de 15 caracteres");
                    return;
                }

                System.out.println("Introduce el departamento del trabajador: ");
                int departamento = sc.nextInt();
                System.out.println("Introduce el salario del trabajador: ");
                double salario = sc.nextDouble();
                System.out.println("Introduce el id del trabajador: ");
                int id = sc.nextInt();
                escribir(choice, apellido, departamento, salario, id);
                
            } else if (choice == 2) {
                System.out.println("Introduce el id del trabajador a buscar: ");
                int id = sc.nextInt();
                leer(choice, id);
            }
            sc.close();
        }catch( Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void escribir(int choice, String apellido, int departamento, double salario, int id){
        File fich = new File("JavaClase\\src\\accesoADatos\\gestionFicheros\\ejerciciosFicheros\\eTrabajador\\info.dat");
        if (choice == 1){
            try {
               
                RandomAccessFile ram = new RandomAccessFile(fich, "rw");
                ram.seek((ram.length()));
                StringBuffer sb = new StringBuffer(apellido);
                sb.setLength(10);
                ram.writeChars(apellido);
                ram.writeInt(departamento);
                ram.writeDouble(salario);
                ram.writeInt(id);
                ram.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else if(choice == 2){
            int pos = (id - 3) * 36;
            leer(id, pos);
        }

        }

    public static void leer(int id, int pos) {
        File fich = new File("JavaClase\\src\\accesoADatos\\gestionFicheros\\ejerciciosFicheros\\eTrabajador\\info.dat");
            
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(fich));
            RandomAccessFile ram = new RandomAccessFile(fich, "r");
            try {
                ram.seek(pos);

                    StringBuilder s = new StringBuilder();
                    for (int i = 0; i < 10; i++) {
                        s.append(ram.readChar());
                    }
                    System.out.println(s.toString());
                    System.out.println("Departamento: " + ram.readInt());
                    System.out.println("Salario: " + ram.readDouble());
                    System.out.println("Id: " + ram.readInt());

                ram.close();
                dis.close();
            } catch (IOException e) {
                
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {     
            e.printStackTrace();
        }
    }
}
