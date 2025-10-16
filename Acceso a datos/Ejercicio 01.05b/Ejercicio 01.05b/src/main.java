import java.io.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        File file = new File("log.txt");
        Scanner scanner = new Scanner(System.in);

        try {
            if (!file.exists()) {
                System.out.println("El fichero 'log.txt' no existe. Introduzca el nombre de otro fichero:");
                String fileName = scanner.nextLine();
                file = new File(fileName);

                if (!file.exists()) {
                    System.out.println("El fichero especificado tampoco existe. Finalizando programa.");
                    return;
                }
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Se produjo un error al leer el fichero: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}