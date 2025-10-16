import java.io.File;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Por favor, proporciona una ruta como argumento.");
            return;
        }
        String ruta = args[0];
        File f = new File(ruta);

        if (f.exists()) {
            if (f.isFile()) {
                System.out.println("El tamaño es de " + f.length());
                System.out.println("Puede ejecutarse: " + f.canExecute());
                System.out.println("Puede leerse: " + f.canRead());
                System.out.println("Puede escribirse: " + f.canWrite());
            } else {
                String[] losArchivos = f.list();
                System.out.println("El directorio " + ruta + " contiene:");
                for (String archivo : losArchivos) {
                    System.out.println("\t" + archivo);
                }
            }
        } else {
            System.out.println("El fichero o ruta no existe");
        }
    }
}