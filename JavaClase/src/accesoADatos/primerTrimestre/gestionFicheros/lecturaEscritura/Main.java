package accesoADatos.gestionFicheros.lecturaEscritura;
import java.io.File;
import java.io.IOException;

public class Main {

    
    public static void main(String[] args) {
        createRenameFichero();
        verDir();
    }


    private static void verDir(){
        String dir =".";
        File fichero = new File(dir);
        File fichero2;
        String[] archivos = fichero.list();

        int tam = archivos.length;
        System.out.println("El numero de ficheros es: " + tam);
        for (int k = 0;k < tam; k++){
            fichero2 = new File(fichero, archivos[k]);
            System.out.println(archivos[k] + " es: ");
            if (fichero2.isDirectory()){
                System.out.println( "un directorio");
            }
            if (fichero2.isFile()){
                System.out.println("un fichero");
            }   
        }
    }

    private static void createRenameFichero(){
        File dir = new File("directorioPruebas");
        File f1 = new File(dir, "prueba1.txt");
        File f2 = new File(dir, "prueba2.txt");

        dir.mkdir();

        try {
            if(f1.createNewFile()){
                System.out.println("Se ha creado el fichero " + f1.getName());
            } else {
                System.out.println("El fichero " + f1.getName() + "no se pudo crear");
            }

            if (f2.createNewFile()) {
                System.out.println("Se ha creado el fichero " + f2.getName());
            } else {
                System.out.println("El fichero " + f2.getName() +  "no se pudo crear");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        File newFile = new File(dir, "nuevoFichero.txt");
        f2.renameTo(newFile);
        System.out.println(f2.getName() + " ha sido renombrado a " + newFile.getName());

    }



    
}
