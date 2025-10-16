import java.io.*;
import java.nio.file.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "output.txt";

        // Escribir en el fichero
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 1; i <= 10; i++) {
                if (i % 2 != 0) {
                    writer.write(i + "\n");
                }
            }
            writer.write("Fin del fichero\n");
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
        }

        // Leer el fichero y mostrarlo en pantalla
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }

        // Leer todo de golpe con readAllLines
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            System.out.println("\nContenido leído con readAllLines:");
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error al leer el fichero con readAllLines: " + e.getMessage());
        }
    }
}