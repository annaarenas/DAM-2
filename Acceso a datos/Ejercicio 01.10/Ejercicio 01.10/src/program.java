import java.util.*;

namespace Proyecto1
 {
    class Program
    {
        static int numero;
        double numDecimal;
        boolean condicional;
        char letra;
        String cadena;

        static void ejercicio1()
        {
            int a = 5, b = 5;
            if(a>b)
            {
				System.out.println("A es mayor que B");
			}
			else
            {
				System.out.println("B es mayor o igual que A");
			}
        }

        static void ejercicio2()
        {
            System.out.println("Introduce una letra");
            Scanner sc = new Scanner(System.in);
            char letra = sc.next().charAt(0);
            if (letra.KeyChar >= 'A' && letra.KeyChar <= 'Z')
            {
                System.out.println("La letra es mayúscula");
            }
            else
            {
                System.out.println("La letra no es mayúscula");
            }
        }
        static void main(String[] args)
        {
            Ejercicio1();
            Ejercicio2();
        }
    }
}
