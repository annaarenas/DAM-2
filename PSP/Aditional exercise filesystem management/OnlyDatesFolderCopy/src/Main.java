import java.io.*;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {
        File sourceFolder = new File("C:\\Users\\annaa\\OneDrive\\Escritorio\\DAM2\\PSP\\Aditional exercise filesystem management\\OnlyDatesFolderCopy\\src\\Files");
        File destFolder = new File("Dates");

        // Regex para detectar fechas en formato dd/mm/yyyy o dd/mm/yy
        String dateRegex = ".*\\b\\d{2}/\\d{2}/(\\d{2}|\\d{4})\\b.*";

        if (!sourceFolder.exists() || !sourceFolder.isDirectory()) {
            System.out.println("The origin folder does not exist.");
            return;
        }

        try {
            if (destFolder.exists()) {
                deleteFolder(destFolder);
            }

            destFolder.mkdir();

            for (File file : sourceFolder.listFiles()) {
                if (file.isFile()) {
                    if (containsDate(file, dateRegex)) {
                        Path destPath = destFolder.toPath().resolve(file.getName());
                        Files.copy(file.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Copied: " + file.getName());
                    }
                }
            }

            System.out.println("COMPLETED");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Elimina carpeta recursivamente
    private static void deleteFolder(File folder) throws IOException {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    Files.delete(f.toPath());
                }
            }
        }
        Files.delete(folder.toPath());
    }

    // Comprueba si un archivo contiene una línea que coincida con el regex
    private static boolean containsDate(File file, String regex) {
        try (RegexReader reader = new RegexReader(new FileReader(file), regex)) {
            return reader.readLine() != null; // Si encuentra alguna línea con fecha, devuelve true
        } catch (IOException e) {
            return false;
        }
    }
}
