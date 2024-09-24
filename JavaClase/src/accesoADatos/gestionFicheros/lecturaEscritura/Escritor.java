package accesoADatos.gestionFicheros.lecturaEscritura;
import java.io.FileWriter;
import java.util.Scanner;

public class Escritor {
    public static void main(String[] args) {
        try {

            Scanner sc = new Scanner(System.in);
            String texto = sc.nextLine();
            FileWriter fw = new FileWriter("src\\accesoADatos\\gestionFicheros\\lecturaEscritura\\ficheroPruebaLectura.txt");
            for (int j = 0; j <= texto.length() - 1; j++){
                fw.write((int)texto.charAt(j));
            }
            fw.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        


    }
}
