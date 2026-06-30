package ejercicios;

public class ejercicio4 {
    enum Estado { EMPTY, OCCUPIED, DELETED }
    
    static class Entry {
        int clave;
        Estado estado = Estado.EMPTY;
        Entry(int c, Estado e) { this.clave = c; this.estado = e; }
    }

    public static void main(String[] args) {
        Entry[] tabla = new Entry[7];
        for(int i=0; i<7; i++) tabla[i] = new Entry(-1, Estado.EMPTY);

        int[] claves = {5, 12, 19, 26};
        for(int c : claves) insertar(tabla, c);

        // 1. Eliminar lógicamente el 12
        eliminar(tabla, 12);
        System.out.println("Estado celda 6 (clave 12) tras eliminar: " + tabla[6].estado);

        // 2. Buscar el 19
        boolean encontrado = buscar(tabla, 19);
        System.out.println("¿Se encontró la clave 19?: " + encontrado);

        // 3. Reinsertar 33
        insertar(tabla, 33);
        System.out.println("Celda 6 después de reinsertar 33: " + tabla[6].estado + " (Clave: " + tabla[6].clave + ")");
    }

    public static void insertar(Entry[] tabla, int clave) {
        int home = clave % 7;
        for(int i=0; i<7; i++) {
            int pos = (home + i) % 7;
            if(tabla[pos].estado == Estado.EMPTY || tabla[pos].estado == Estado.DELETED) {
                tabla[pos].clave = clave;
                tabla[pos].estado = Estado.OCCUPIED;
                return;
            }
        }
    }

    public static void eliminar(Entry[] tabla, int clave) {
        int home = clave % 7;
        for(int i=0; i<7; i++) {
            int pos = (home + i) % 7;
            if(tabla[pos].estado == Estado.EMPTY) return;
            if(tabla[pos].estado == Estado.OCCUPIED && tabla[pos].clave == clave) {
                tabla[pos].estado = Estado.DELETED;
                return;
            }
        }
    }

    public static boolean buscar(Entry[] tabla, int clave) {
        int home = clave % 7;
        for(int i=0; i<7; i++) {
            int pos = (home + i) % 7;
            if(tabla[pos].estado == Estado.EMPTY) return false;
            if(tabla[pos].estado == Estado.OCCUPIED && tabla[pos].clave == clave) return true;
        }
        return false;
    }
}
