import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el nombre del fichero de entrada
        System.out.print("Introduce el nombre del fichero de entrada: ");
        String inputFileName = scanner.nextLine();

        // Solicitar el nombre del fichero de salida
        System.out.print("Introduce el nombre del fichero de salida: ");
        String outputFileName = scanner.nextLine();

        List<String> lines = new ArrayList<>();

        // Leer el contenido del fichero de entrada
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
            return;
        }

        // Invertir el orden de las líneas
        Collections.reverse(lines);

        // Escribir el contenido invertido en el fichero de salida
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
        }

        System.out.println("El contenido del fichero se ha volcado e invertido correctamente.");
    }
}