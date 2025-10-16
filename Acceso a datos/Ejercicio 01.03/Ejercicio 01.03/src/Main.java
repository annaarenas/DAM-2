import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el ancho del triángulo: ");
        int width = scanner.nextInt();

        System.out.print("Introduce el alto del triángulo: ");
        int height = scanner.nextInt();

        try (FileWriter writer = new FileWriter("triangle.txt")) {
            for (int i = 1; i <= height; i++) {
                int stars = (int) Math.ceil((double) i * width / height);
                writer.write("*".repeat(stars) + "\n");
            }
            System.out.println("El triángulo se ha escrito en el fichero 'triangle.txt'.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }
}