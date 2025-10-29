import casos.Caso1Alumnos;
import casos.Caso2Productos;
import casos.Caso3Libros;
import casos.Caso4Empleados;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n=== CASO 1: ALUMNOS ===");
        Caso1Alumnos.ejecutar();

        System.out.println("\n=== CASO 2: PRODUCTOS ===");
        Caso2Productos.ejecutar();

        System.out.println("\n=== CASO 3: LIBROS ===");
        Caso3Libros.ejecutar();

        System.out.println("\n=== CASO 4: EMPLEADOS ===");
        Caso4Empleados.ejecutar();
    }
}