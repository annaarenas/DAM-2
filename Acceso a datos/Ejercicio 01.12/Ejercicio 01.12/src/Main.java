import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Solicitar el nombre del fichero de origen
            System.out.print("Introduce el nombre del fichero de origen: ");
            String sourceFileName = scanner.nextLine();
            Path sourcePath = Paths.get(sourceFileName);

            // Solicitar el nombre del fichero de destino
            System.out.print("Introduce el nombre del fichero de destino: ");
            String destinationFileName = scanner.nextLine();
            Path destinationPath = Paths.get(destinationFileName);

            // Leer todo el contenido del fichero de origen
            byte[] fileContent = Files.readAllBytes(sourcePath);

            // Escribir el contenido en el fichero de destino
            Files.write(destinationPath, fileContent);

            System.out.println("El fichero se ha copiado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al copiar el fichero: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}