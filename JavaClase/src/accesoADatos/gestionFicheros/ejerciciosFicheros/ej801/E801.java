package accesoADatos.gestionFicheros.ejerciciosFicheros.ej801;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class E801 {
    public static void main(String[] args) {
        File fich = new File("JavaClase\\src\\accesoADatos\\gestionFicheros\\ejerciciosFicheros\\ej1\\entrada801.dat");
        ArrayList <Double> edades = new ArrayList<>();
        ArrayList <Double> desEst = new ArrayList<>();
        int nAlumnos = 0;
        try {
            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(fich)));
            
                try {
                    while (true) {
                        edades.add((double)dis.readInt());
                        nAlumnos++;
                    }
                    
                } catch (EOFException e) {
                    System.out.println("Fin del Archivo");
                    System.out.println("Número de alumnos: " + nAlumnos);
                    
                    // Cálculo de la media de las edades
                    double mArit = 0;
                    for (int k = 0; k < edades.size(); k++) {
                        mArit +=  (double)edades.get(k);
                    }
                    mArit = mArit / nAlumnos;
                    System.out.println("Media aritmética de las edades: " + mArit);

                    // Cálculo de la edad más joven
                    double mJoven = edades.get(0);
                    for (int k = 0; k < edades.size(); k++){
                        if  (edades.get(k) < mJoven) {  
                            mJoven = edades.get(k);
                        }
                    }
                    System.out.println("Más jóven: " + mJoven);

                    //Cálculo de la edad más viejo
                    double mViejo = edades.get(0);
                    for (int k = 0; k < edades.size(); k++) {
                        if (edades.get(k) > mViejo) {
                            mViejo = edades.get(k);
                        }
                    }
                    System.out.println("Más viejo: " + mViejo);

                    // Cálculo del número de menores de edad
                    double menoresEdad = 0;
                    for(int k = 0; k < edades.size(); k++){
                        if (edades.get(k) < 18){
                            menoresEdad++;
                        }
                    }
                    System.out.println("Número de menores de edad: " + menoresEdad);


                    //Calculo de la desviación estandar
                    double mediaDiferencias = 0;
                    for (int k = 0; k  < edades.size(); k++) {
                        desEst.add((edades.get(k) - mArit) * edades.get(k));
                    }

                    for (int k = 0; k < desEst.size(); k++) {
                        mediaDiferencias += desEst.get(k);
                    }

                    mediaDiferencias = mediaDiferencias / nAlumnos;
                    double raiz =  Math.sqrt(mediaDiferencias);
                    System.out.println("Desviación estándar: " + raiz);

                    dis.close();
                }

        } catch (Exception e) {
            System.out.println("Fin del archivo");
        }
    }
}

