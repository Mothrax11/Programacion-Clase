package accesoADatos.gestionFicheros.lecturaEscritura;
import java.io.FileWriter;
import java.util.Scanner;

public class Escritor {
    public static void main(String[] args) {
        try {

            Scanner sc = new Scanner(System.in);
            String texto = sc.nextLine();
            FileWriter fw = new FileWriter("src\\accesoADatos\\gestionFicheros\\lecturaEscritura\\ficheroPruebaLectura.txt", true);
            for (int j = 0; j <= texto.length() - 1; j++){
                fw.write((int)texto.charAt(j));
            }
            sc.close();
            String cadena[] = { "Álava",
                    "Albacete",
                    "Alicante",
                    "Almería",
                    "Asturias",
                    "Ávila",
                    "Badajoz",
                    "Baleares",
                    "Barcelona",
                    "Burgos",
                    "Cáceres",
                    "Cádiz",
                    "Cantabria",
                    "Castellón",
                    "Ceuta",
                    "Ciudad Real",
                    "Córdoba",
                    "Cuenca",
                    "Girona",
                    "Granada",
                    "Guadalajara",
                    "Guipúzcoa",
                    "Huelva",
                    "Huesca",
                    "Jaén",
                    "La Coruña",
                    "La Rioja",
                    "Las Palmas",
                    "León",
                    "Lleida",
                    "Lugo",
                    "Madrid",
                    "Málaga",
                    "Melilla",
                    "Murcia",
                    "Navarra",
                    "Ourense",
                    "Palencia",
                    "Pontevedra",
                    "Salamanca",
                    "Segovia",
                    "Sevilla",
                    "Soria",
                    "Tarragona",
                    "Tenerife",
                    "Teruel",
                    "Toledo",
                    "Valencia",
                    "Valladolid",
                    "Vizcaya",
                    "Zamora",
                    "Zaragoza"};
            for(String s : cadena){
                fw.write((s + "\n" ));
            }

            fw.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        


    }
}
