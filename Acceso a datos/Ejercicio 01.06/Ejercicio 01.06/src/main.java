import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar filas y columnas
        System.out.print("Introduce la cantidad de filas: ");
        int filas = scanner.nextInt();
        System.out.print("Introduce la cantidad de columnas: ");
        int columnas = scanner.nextInt();

        // Crear el archivo y escribir el rectángulo
        try (FileWriter writer = new FileWriter("rectangulo.txt")) {
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    writer.write("*");
                }
                writer.write(System.lineSeparator()); // Salto de línea
            }
            System.out.println("El rectángulo se ha creado en el archivo 'rectangulo.txt'.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        }

        scanner.close();
    }
}