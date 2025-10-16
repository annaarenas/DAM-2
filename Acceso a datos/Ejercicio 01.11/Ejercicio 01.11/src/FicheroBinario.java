import java.io.FileOutputStream;
import java.io.IOException;

public class FicheroBinario {
    public static void crearFicheroBinario() {
        String nombreFichero = "input.bin";

        byte[] datos = {
                65, 66, 67, // A B C
                10, // salto de línea (no imprimible)
                32, // espacio
                33, 64, 35, // ! @ #
                (byte)200, // byte no imprimible (>127)
                68, 69, 70, // D E F
                9, // tabulador (no imprimible)
                97, 98, 99, // a b c
                (byte)0, // null (no imprimible)
                100, 101, 102 // d e f
        };

        try (FileOutputStream fos = new FileOutputStream(nombreFichero)) {
            fos.write(datos);
            System.out.println("Fichero binario '" + nombreFichero + "' creado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
