package Actividades;

public class HashC {

    public HashC() {
    }
    private static class Element {
        Register register;
        boolean isAvailable;
        boolean isDeleted;

        public Element () {
            this.register = null;
            this.isAvailable = true;
            this.isDeleted = false;
        }
    }
    private Element[] table;
    private int size;

    public HashC(int size) {
        this.size = size;
        this.table = new Element[size];
        for (int i = 0; i < size; i++) {
            table[i] = new Element();
        }
    }
    private int hash(int key) {
        return key % size;
    }
    public void insert(Register register) {
        int key = register.getKey();
        int index = hash(key);
        int firstDeletedIndex = -1;

        while (!table[index].isAvailable) {
            if (table[index].isDeleted && firstDeletedIndex == -1) {
                firstDeletedIndex = index;
            }
            index = (index + 1) % size;
        }

        if (firstDeletedIndex != -1) {
            index = firstDeletedIndex;
        }

        table[index].register = register;
        table[index].isAvailable = false;
        table[index].isDeleted = false;
    }
    public Register search(int key) {
        int index = hash(key);
        int start = index;
        while (!table[index].isAvailable) {
            if (!table[index].isDeleted && table[index].register != null && table[index].register.getKey() == key) {
                return table[index].register;
            }
            index = (index + 1) % size;
            if (index == start) {
                break;
            }
        }
        return null;
    }
    public void delete(int key) {
        int index = hash(key);
        int start = index;
        while (!table[index].isAvailable) {
            if (!table[index].isDeleted && table[index].register != null && table[index].register.getKey() == key) {
                table[index].register = null;
                table[index].isDeleted = true;
                table[index].isAvailable = false;
                return;
            }
            index = (index + 1) % size;
            if (index == start) {
                break;
            }
        }
    }
    public void printTable() {
        for (int i = 0; i < size; i++) {
            if (!table[i].isAvailable && !table[i].isDeleted) {
                System.out.println("Index " + i + ": " + table[i].register.ToString());
            } else if (table[i].isDeleted) {
                System.out.println("Index " + i + ": <deleted>");
            } else {
                System.out.println("Index " + i + ": null");
            }
        }
    }
}
