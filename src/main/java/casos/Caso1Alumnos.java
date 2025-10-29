package casos;

import modelo.Alumno;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Caso1Alumnos {

    public static void ejecutar() {
        // Datos de ejemplo
        List<Alumno> alumnos = List.of(
                new Alumno("Guillermina", 10, "Java"),
                new Alumno("Camila", 8.5, "Java"),
                new Alumno("Nicolás", 6.5, "Python"),
                new Alumno("Máximo", 9.5, "Java"),
                new Alumno("Agustín", 5.5, "Python")
        );

        // Nombres de aprobados (nota >= 7), en mayúsculas y ordenados
        List<String> aprobados = alumnos.stream()
                .filter(a -> a.getNota() >= 7)
                .map(a -> a.getNombre().toUpperCase())
                .sorted() // orden natural
                .toList(); // convierte el stream en lista inmutable
        System.out.println("Aprobados (mayúsculas y ordenados): " + aprobados);

        // Promedio general de notas
        double promedioGeneral = alumnos.stream()
                .mapToDouble(Alumno::getNota)
                .average()
                .orElse(0);
        System.out.println("Promedio general: " + promedioGeneral);

        // Agrupar alumnos por curso
        Map<String, List<Alumno>> alumnosPorCurso = alumnos.stream() // devuelve un String como "Java" y una lista de Alumnos.
                .collect(Collectors.groupingBy(Alumno::getCurso));
        System.out.println("\nAlumnos agrupados por curso:");
        alumnosPorCurso.forEach((curso, lista) -> {
            System.out.println(" Curso: " + curso);
            for (Alumno a : lista) {
                System.out.println(" " + a);
            }
        });

        // Mejores 3 promedios
        List<Alumno> top3 = alumnos.stream()
                .sorted(Comparator.comparingDouble(Alumno::getNota).reversed())
                .limit(3)
                .toList();
        System.out.println("\nTop 3 mejores promedios:");
        top3.forEach(System.out::println);
    }
}