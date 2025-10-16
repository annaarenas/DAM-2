import java.io.*;

public class Main {
    public static void main(String[] args) {
        FicheroBinario.crearFicheroBinario();
        String inputFileName = "input.bin";
        String outputFileName = "output.txt";

        try (FileInputStream fis = new FileInputStream(inputFileName);
             FileWriter fw = new FileWriter(outputFileName)) {

            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                if (byteRead >= 32 && byteRead <= 127) {
                    fw.write(byteRead);
                }
            }

            System.out.println("El contenido imprimible se ha escrito correctamente a " + outputFileName);

        } catch (IOException e) {
            System.err.println("Error al procesar los archivos: " + e.getMessage());
        }
    }
}