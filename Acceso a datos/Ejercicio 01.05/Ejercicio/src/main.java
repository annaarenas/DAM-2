import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        // Formateamos fecha y hora
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Fecha y hora actuales
        LocalDateTime now = LocalDateTime.now();
        String date = now.format(dateFormatter);
        String time = now.format(timeFormatter);

        // Pedir al usuario que introduzca un texto
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un texto: ");
        String userInput = scanner.nextLine();

        // Crear o añadir al fichero log.txt
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(date + " " + time + " " + userInput + System.lineSeparator());
            System.out.println("Texto añadido al fichero log.txt");
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }
}