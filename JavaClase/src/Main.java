import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int cantidad = sc.nextInt();

        int a = 0;
        int b = 1;

        for (int k = 0; k <= cantidad; k++){
            int suma = a + b;
            a = b;
            b = suma;
            System.out.println(suma);
        }
    }
}
