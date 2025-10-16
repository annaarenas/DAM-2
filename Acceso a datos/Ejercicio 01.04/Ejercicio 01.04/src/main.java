import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el ancho del rectángulo: ");
        int width = scanner.nextInt();
        System.out.print("Introduce el alto del rectángulo: ");
        int height = scanner.nextInt();

        if (width < 2 || height < 2) {
            System.out.println("El ancho y el alto deben ser al menos 2.");
            return;
        }

        // Crear el rectángulo hueco y escribirlo en el archivo
        try (FileWriter writer = new FileWriter("rectangle.txt")) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                        writer.write("*");
                    } else {
                        writer.write(" ");
                    }
                }
                writer.write(System.lineSeparator());
            }
            System.out.println("Rectángulo escrito en 'rectangle.txt'.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
