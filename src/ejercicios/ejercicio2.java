package ejercicios;

import java.util.Arrays;

public class ejercicio2 {
    public static void main(String[] args) {
        int[] valores = {10, 17, 24, 31, 4};
        
        // Sondeo Lineal
        int[] tablaLineal = new int[7];
        Arrays.fill(tablaLineal, -1);
        System.out.println("=== SONDEO LINEAL ===");
        for (int val : valores) {
            int home = val % 7;
            int i = 0;
            while (true) {
                int pos = (home + i) % 7;
                if (tablaLineal[pos] == -1) {
                    tablaLineal[pos] = val;
                    System.out.println("Insertado " + val + " en pos " + pos + " (i=" + i + ")");
                    break;
                }
                i++;
            }
        }
        System.out.println("Tabla Lineal Final: " + Arrays.toString(tablaLineal) + "\n");

        // Sondeo Cuadrático
        int[] tablaCuadratica = new int[7];
        Arrays.fill(tablaCuadratica, -1);
        System.out.println("=== SONDEO CUADRÁTICO ===");
        for (int val : valores) {
            int home = val % 7;
            int i = 0;
            while (true) {
                int pos = (home + (i * i)) % 7;
                if (tablaCuadratica[pos] == -1) {
                    tablaCuadratica[pos] = val;
                    System.out.println("Insertado " + val + " en pos " + pos + " (i=" + i + ")");
                    break;
                }
                i++;
            }
        }
        System.out.println("Tabla Cuadrática Final: " + Arrays.toString(tablaCuadratica));
    }
}
