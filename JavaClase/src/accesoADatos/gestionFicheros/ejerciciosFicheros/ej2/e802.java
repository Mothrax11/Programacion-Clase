package accesoADatos.gestionFicheros.ejerciciosFicheros.ej2;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;

public class e802 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rutaArchivo = sc.nextLine();
        String nombreArchivo =  sc.nextLine();
        File fich = new File (rutaArchivo, nombreArchivo);

        try {
            int k;
            FileReader fr = new FileReader(fich);

        while((k = fr.read()) != -1) {
            if (k == 32){
                System.out.print("-");
            } else{
                char letra = (char)k;
                String ltr = Character.toString(letra);
                System.out.print(ltr.toUpperCase());
            }
        }
        fr.close();
        sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
