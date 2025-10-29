package casos;

import modelo.Producto;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Caso2Productos {

    public static void ejecutar() {
        List<Producto> productos = List.of(
                new Producto("Notebook", "Electrónica", 450.0, 5),
                new Producto("Mouse", "Electrónica", 80.0, 25),
                new Producto("Zapatillas", "Indumentaria", 120.0, 15),
                new Producto("Campera", "Indumentaria", 250.0, 8),
                new Producto("Silla Gamer", "Muebles", 300.0, 4),
                new Producto("Lámpara", "Muebles", 90.0, 10)
        );

        // Productos con precio > 100, ordenados por precio descendente
        List<Producto> filtrados = productos.stream()
                .filter(p -> p.getPrecio() > 100)
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                .toList();
        System.out.println("Productos con precio mayor a 100 (orden descendente): ");
        filtrados.forEach(System.out::println);

        // Productos agrupados por categoría y cálculo de stock total
        Map<String, Integer> stockPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria, Collectors.summingInt(Producto::getStock)));
        System.out.println("\nStock total por categoría:");
        stockPorCategoria.forEach((categoria, stock) -> System.out.println(" " + categoria + ": " + stock));

        // String con nombre y precio separados por ";"
        String nombresYPrecios = productos.stream()
                .map(p -> p.getNombre() + " $" + p.getPrecio())
                .collect(Collectors.joining("; "));
        System.out.println("\nLista de productos (nombre y precio):\n" + nombresYPrecios);

        // Calcular precio promedio general
        double promedioGeneral = productos.stream()
                .mapToDouble(p -> p.getPrecio())
                .average()
                .orElse(0);
        System.out.println("\nPrecio promedio general: $" + promedioGeneral);

        // Precio promedio por categoría
        Map<String, Double> promedioPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(p -> p.getCategoria(), Collectors.averagingDouble(p -> p.getPrecio())));
        System.out.println("\nPrecio promedio por categoría:");
        // Mi forEach() va a recibir los dos parámetros de Map<String, Double>
        promedioPorCategoria.forEach((categoria, promedio) -> System.out.println(" " + categoria + ": $" + promedio));
    }
}