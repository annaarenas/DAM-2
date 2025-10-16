import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Uso: java Main <fichero1> <fichero2> <ficheroSalida>");
            return;
        }

        String fichero1 = args[0];
        String fichero2 = args[1];
        String ficheroSalida = args[2];

        List<String> lineas = new ArrayList<>();

        // Leer el contenido del primer fichero
        try (BufferedReader br = new BufferedReader(new FileReader(fichero1))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + fichero1);
            e.printStackTrace();
            return;
        }

        // Leer el contenido del segundo fichero
        try (BufferedReader br = new BufferedReader(new FileReader(fichero2))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + fichero2);
            e.printStackTrace();
            return;
        }

        // Ordenar las líneas alfabéticamente
        Collections.sort(lineas);

        // Escribir el contenido ordenado en el fichero de salida
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroSalida))) {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + ficheroSalida);
            e.printStackTrace();
        }

        System.out.println("Fichero de salida generado correctamente: " + ficheroSalida);
    }
}