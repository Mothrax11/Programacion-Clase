package accesoADatos.gestionFicheros.xml.xmlSax;

public class Empleados {
    private String nombre;
    private int numero;
    private double salario;

    public void main(String[] args) {
        System.out.println(toString());
    }

    public Empleados (String nombre, int numero, double salario){
        this.nombre = nombre;
        this.numero = numero;
        this.salario = salario;
    }
    
    public String toString() {
        return "Nombre: " + nombre + "\n" + "Numero: " + numero + "\n" + "Salario: : " + salario + "\n";
    }

    
}
