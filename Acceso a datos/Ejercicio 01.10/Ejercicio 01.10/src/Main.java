import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java Main <ficheroEntrada.cs> <ficheroSalida.java>");
            return;
        }

        String ficheroEntrada = args[0];
        String ficheroSalida = args[1];

        try (BufferedReader br = new BufferedReader(new FileReader(ficheroEntrada));
             PrintWriter pw = new PrintWriter(new FileWriter(ficheroSalida))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String convertida = convertirLinea(linea);
                pw.println(convertida);
            }

            System.out.println("Conversión completada. Archivo generado: " + ficheroSalida);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String convertirLinea(String linea) {
        // Imports
        String original = linea;
        linea = linea.replace("using System;", "import java.util.*;");

        // Tipos básicos
        linea = linea.replace("string", "String");
        linea = linea.replace("bool", "boolean");

        // Console.WriteLine -> System.out.println
        linea = linea.replace("Console.WriteLine", "System.out.println");

        // Console.ReadKey(true) -> new Scanner(System.in).next().charAt(0)
        if (linea.contains("Console.ReadKey")) {
            linea = linea.replace("var letra = Console.ReadKey(true);",
                    "Scanner sc = new Scanner(System.in);\n            char letra = sc.next().charAt(0);");
        }

        // Métodos y main en minúsculas
        linea = linea.replace("Main", "main");
        linea = linea.replace("static void Ejercicio1()", "static void ejercicio1()");
        linea = linea.replace("static void Ejercicio2()", "static void ejercicio2()");

        // Llaves: en C# suelen ir en nueva línea, en Java las dejamos en la misma línea
        linea = linea.replaceAll("\\s*\\{", " {");

        return linea.equals(original) ? linea : linea;
    }
}
