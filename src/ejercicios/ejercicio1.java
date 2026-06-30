package ejercicios;

import java.util.Arrays;

public class ejercicio1 {
    public static void main(String[] args) {
        int[] tabla = new int[11];
        Arrays.fill(tabla, -1);
        
        int[] valores = {3, 14, 25, 36, 47, 58};
        
        for (int val : valores) {
            int pos = val % 11;
            tabla[pos] = val; // Sobreescribe por colisión según diseño base sin tratamiento
        }
        
        System.out.println("--- TABLA HASH EJERCICIO 1 ---");
        for (int i = 0; i < tabla.length; i++) {
            System.out.println("Índice " + i + ": " + (tabla[i] == -1 ? "Vacío" : tabla[i]));
        }
    }
}
