package ejercicios;

import java.util.Arrays;

public class ejercicio5 {
    public static void main(String[] args) {
        int[] tabla = new int[7];
        Arrays.fill(tabla, -1);
        int n = 0;

        int[] valores = {2, 9, 16, 23, 4, 11};

        for (int val : valores) {
            tabla = insertarConSondeo(tabla, val);
            n++;
            double alpha = (double) n / tabla.length;
            System.out.printf("Insertado: %d | Tam Tabla: %d | Factor Carga: %.2f\n", val, tabla.length, alpha);

            if (alpha > 0.75) {
                System.out.println(">> ALERTA: Alpha superó 0.75. Realizando Rehashing a tamaño 17...");
                tabla = rehashing(tabla, 17);
            }
        }
        System.out.println("\nEstado Final de la Tabla: " + Arrays.toString(tabla));
    }

    public static int[] insertarConSondeo(int[] t, int val) {
        int M = t.length;
        int home = val % M;
        for (int i = 0; i < M; i++) {
            int pos = (home + i) % M;
            if (t[pos] == -1) {
                t[pos] = val;
                break;
            }
        }
        return t;
    }

    public static int[] rehashing(int[] viejaTabla, int nuevoTam) {
        int[] nuevaTabla = new int[nuevoTam];
        Arrays.fill(nuevaTabla, -1);
        
        for (int val : viejaTabla) {
            if (val != -1) {
                insertarConSondeo(nuevaTabla, val);
            }
        }
        return nuevaTabla;
    }
}
