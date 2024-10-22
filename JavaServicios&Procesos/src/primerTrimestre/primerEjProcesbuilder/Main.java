package primerTrimestre.primerEjProcesbuilder;

public class Main {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("calc.exe");
        try {
        Process proceso = pb.start();
            System.out.println("Número de proceso: " + proceso.pid());
            System.out.println("Info del proceso: " + proceso.info());
            System.out.println(proceso.isAlive());
            
            if (proceso.pid() % 10 == 0){
                ProcessBuilder p1 = new ProcessBuilder("mspaint.exe");
                Process proceso1 = p1.start();
            } else {
                ProcessBuilder p2 = new ProcessBuilder("dxdiag.exe");
                Process proceso2 = p2.start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage()); 
        }
    }
}
