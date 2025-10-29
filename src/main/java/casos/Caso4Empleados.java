package casos;

import modelo.Empleado;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Caso4Empleados {

    public static void ejecutar() {
        List<Empleado> empleados = List.of(
                new Empleado("Guille", "Desarrollo", 3200, 28),
                new Empleado("Leila", "Diseño", 2500, 26),
                new Empleado("Bauti", "Soporte", 1800, 23),
                new Empleado("Maxi", "Desarrollo", 4100, 31),
                new Empleado("Juanfra", "Diseño", 1900, 25),
                new Empleado("Renzo", "Soporte", 2600, 29)
        );

        // Empleados con salario > 2000, ordenados por salario descendente
        List<Empleado> filtrados = empleados.stream()
                .filter(e -> e.getSalario() > 2000)
                .sorted(Comparator.comparingDouble(Empleado::getSalario).reversed())
                .toList();
        System.out.println("Empleados con salario mayor a 2000 (descendente):");
        filtrados.forEach(System.out::println);

        // Salario promedio general
        double promedioGeneral = empleados.stream()
                .mapToDouble(Empleado::getSalario)
                .average()
                .orElse(0);
        System.out.println("\nSalario promedio general: $" + promedioGeneral);

        // Agrupar empleados por departamento y sumar salarios
        Map<String, Double> salarioPorDepto = empleados.stream()
                .collect(Collectors.groupingBy(Empleado::getDepartamento, Collectors.summingDouble(Empleado::getSalario)));

        System.out.println("\nSuma total de salarios por departamento:");
        salarioPorDepto.forEach((depto, total) -> System.out.println("  " + depto + ": $" + total));

        // Nombres de los 2 empleados más jóvenes
        List<String> masJovenes = empleados.stream()
                .sorted(Comparator.comparingInt(Empleado::getEdad))
                .limit(2)
                .map(Empleado::getNombre)
                .toList();
        System.out.println("\nLos 2 empleados más jóvenes:");
        masJovenes.forEach(System.out::println);
    }
}