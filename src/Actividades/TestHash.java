package Actividades;

public class TestHash {
    public static void main(String[] args) {
        HashC hashTable = new HashC(11);
        // Insert some registers
        hashTable.insert(new Register(34, "Alice"));
        hashTable.insert(new Register(3, "Bob"));
        hashTable.insert(new Register(7, "Charlie"));
        hashTable.insert(new Register(30, "David"));
        hashTable.insert(new Register(11, "Eve"));
        hashTable.insert(new Register(8, "Frank"));
        hashTable.insert(new Register(7, "Grace"));
        hashTable.insert(new Register(23, "Hannah"));
        hashTable.insert(new Register(41, "Ivy"));
        hashTable.insert(new Register(16, "Jack"));
        hashTable.insert(new Register(34, "Kathy"));
    //Tabla antes de eliminar la clave 30
        System.out.println("Tabla antes de eliminar la clave 30:");
        hashTable.printTable();
    // Eliminar la clave 30
        hashTable.delete(30);
    //Tabla después de eliminar la clave 30
        System.out.println("\nTabla después de eliminar la clave 30:");
        hashTable.printTable();

    }
}
