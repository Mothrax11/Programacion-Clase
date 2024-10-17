package accesoADatos.pruebaInicial.archivos.documentaciones;

public class Nie extends Documentacion {

    private int numeros;
    private char letraInicial;
    private char letraFinal;
    private boolean nieValido;

    public Nie(int numeros, char letraInicial, char letraFinal){
        this.numeros = numeros;
        this.letraInicial = letraInicial;
        this.letraFinal = letraFinal;
    }


    @Override
    boolean validar() {
        
    try {
        Integer.valueOf(numeros);

        if (((int)letraInicial >= 65 && (int)letraInicial <= 90 ) || ((int)letraInicial >= 97 && (int)letraInicial <= 122 )){
            if (((int)letraFinal >= 65 && (int)letraFinal <= 90 ) || ((int)letraFinal >= 97 && (int)letraFinal <= 122 )){
                nieValido = true;
            }
        }

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
        return false;
    }

    @Override
    public String toString() {
        return letraInicial + String.valueOf(numeros) + letraFinal;
    }

    @Override
    String mostar() {
        if (nieValido){
            return toString();
        } else {
            return "NIE no válido";
        }
    }
    
}
