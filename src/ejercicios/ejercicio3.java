package ejercicios;

import java.util.LinkedList;

public class ejercicio3 {
    public static void main(String[] args) {
        LinkedList<nodo>[] tabla = new LinkedList[7];
        for (int i = 0; i < 7; i++) tabla[i] = new LinkedList<>();

        // Inserciones
        int[] claves = {10, 17, 24, 31, 5, 12};
        String[] nombres = {"Juan", "Ana", "Luis", "Rosa", "Pedro", "Carla"};
        
        for (int i = 0; i < claves.length; i++) {
            int pos = claves[i] % 7;
            tabla[pos].add(new nodo(claves[i], nombres[i]));
        }

        // 1. Buscar clave 24
        int posBuscar = 24 % 7;
        int nodoIdx = 0;
        for (nodo n : tabla[posBuscar]) {
            if (n.getclave() == 24) {
                System.out.println("Clave 24 encontrada: " + n.getname() + " en Índice Tabla: " + posBuscar + ", posición nodo: " + (nodoIdx + 1));
            }
            nodoIdx++;
        }

        // 2. Eliminar clave 17
        int posEliminar = 17 % 7;
        tabla[posEliminar].removeIf(nodo -> nodo.getclave() == 17);
        
        System.out.println("\n--- Tabla Abierta tras eliminar clave 17 ---");
        System.out.println("Nodos restantes en índice 3: " + tabla[3].size());
    }
}
