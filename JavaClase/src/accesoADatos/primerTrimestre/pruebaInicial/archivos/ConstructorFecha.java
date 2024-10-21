package accesoADatos.pruebaInicial.archivos;

public class ConstructorFecha {

    public static String conversorFecha(int dia, int mes, int ano){

        String fecha;

        if ((dia > 0 && dia <= 9) && (mes > 0 && mes <= 9)) {
            fecha = "0" + dia + "/" + "0" + mes + "/" + ano;
        } else if ((dia > 0 && dia <= 9) && (mes > 9)) {
            fecha = "0" + dia + "/" + mes + "/" + ano;
        } else if ((dia > 9) && (mes > 0 && mes <= 9)) {
            fecha = dia + "/" + "0" + mes + "/" + ano;
        } else {
            fecha = dia + "/" + mes + "/" + ano;
        }

        return fecha;
    }
}
