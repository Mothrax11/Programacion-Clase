package accesoADatos.pruebaInicial.archivos.documentaciones;

public class Nif extends Documentacion {

    private String letra;
    private int numeros;
    private boolean nifValidado;

    public Nif(String letra, int numeros){
        this.letra = letra;
        this.numeros = numeros;
    }

    @Override
    boolean validar() {

        try {

            Integer.valueOf(numeros);

            if ((letra.matches("[A-Z]*") || letra.matches("[a-z]*"))) {
                nifValidado = true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
        return false; 
    }
    
    @Override
    public String toString() {
        return numeros + letra;
    }

    @Override
    String mostar() {

        if (nifValidado){
            return toString();
        } else {
            return "NIF no válido";
        }
    }
    
}
