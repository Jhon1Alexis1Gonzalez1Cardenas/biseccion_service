package BiseLibJava;

public class BiseLibJava {

    public native double[] bisecionjava(double x1, double x2, String funcion);

    public BiseLibJava() {
        try{
            System.loadLibrary("libbiseLibJava");
            System.out.println("Biblioteca cargada exitosamente!");
        }catch (UnsatisfiedLinkError e){
            System.err.println("Carga de la biblioteca fallida: " + e.getMessage());
        }
    }

}
