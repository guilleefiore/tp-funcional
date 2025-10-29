package casos;

import modelo.Libro;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Caso3Libros {

    public static void ejecutar() {
        List<Libro> libros = List.of(
                new Libro("El Quijote", "Cervantes", 863, 1500),
                new Libro("Cien años de soledad", "García Márquez", 417, 1200),
                new Libro("El Principito", "Saint-Exupéry", 96, 600),
                new Libro("Rayuela", "Cortázar", 600, 1100),
                new Libro("Ficciones", "Borges", 224, 800),
                new Libro("Los Detectives Salvajes", "Bolaño", 608, 1400)
        );

        // Títulos de libros con más de 300 páginas, ordenados alfabéticamente
        List<String> titulosLargos = libros.stream()
                .filter(l -> l.getPaginas() > 300)
                .map(l -> l.getTitulo())
                .sorted()
                .toList();
        System.out.println("Libros con más de 300 páginas (ordenados):");
        titulosLargos.forEach(System.out::println);

        // Promedio de páginas de todos los libros
        double promedioPaginas = libros.stream()
                .mapToInt(l -> l.getPaginas())
                .average()
                .orElse(0);
        System.out.println("\nPromedio de páginas: " + promedioPaginas);

        // Agrupar libros por autor y contar cuántos libros tiene cada uno
        Map<String, Long> librosPorAutor = libros.stream()
                .collect(Collectors.groupingBy(l  -> l.getAutor(), Collectors.counting()));
        System.out.println("\nCantidad de libros por autor:");
        librosPorAutor.forEach((autor, cantidad) -> System.out.println(" " + autor + ": " + cantidad));

        // Libro más caro
        Optional<Libro> libroMasCaro = libros.stream() // uso Optional porque puede existir una lista de libros como no
                .max(Comparator.comparingDouble(l -> l.getPrecio()));
        libroMasCaro.ifPresent(l -> {
            System.out.println("\nLibro más caro: " + l);
        });
    }
}