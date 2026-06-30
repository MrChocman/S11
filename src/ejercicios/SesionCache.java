package ejercicios;

public class SesionCache {
    
    // Nodo para la lista enlazada (manejo de colisiones por encadenamiento)
    private class Node {
        Sesion session;
        Node next;

        public Node(Sesion session) {
            this.session = session;
            this.next = null;
        }
    }

    private Node[] table;
    private int capacity;
    private int size;

    public SesionCache(int capacity) {
        this.capacity = capacity;
        this.table = new Node[capacity];
        this.size = 0;
    }

    // Función hash para obtener el índice
    private int getBucketIndex(String token) {
        return Math.abs(token.hashCode()) % capacity;
    }

    // 1. Registrar una nueva sesión
    public void login(String token, String username, String role, long ttlMs) {
        int index = getBucketIndex(token);
        long expiresAt = System.currentTimeMillis() + ttlMs;
        
        Node head = table[index];
        Node current = head;
        
        // Buscar si el token ya existe para actualizarlo
        while (current != null) {
            if (current.session.token.equals(token)) {
                current.session.username = username;
                current.session.role = role;
                current.session.expiresAt = expiresAt;
                return;
            }
            current = current.next;
        }

        // Si no existe, insertamos un nuevo nodo al inicio de la lista
        Sesion newSession = new Sesion(token, username, role, expiresAt);
        Node newNode = new Node(newSession);
        newNode.next = head;
        table[index] = newNode;
        size++;
    }

    // 2. Validar una sesión
    public Sesion validate(String token) {
        int index = getBucketIndex(token);
        Node current = table[index];

        while (current != null) {
            if (current.session.token.equals(token)) {
                if (System.currentTimeMillis() < current.session.expiresAt) {
                    return current.session; // Válida y no expirada
                } else {
                    return null; // El token existe pero ya expiró
                }
            }
            current = current.next;
        }
        return null; // El token no existe
    }

    // 3. Cerrar sesión explícitamente
    public void logout(String token) {
        int index = getBucketIndex(token);
        Node current = table[index];
        Node prev = null;

        while (current != null) {
            if (current.session.token.equals(token)) {
                if (prev == null) {
                    // El nodo a eliminar es el primero (head)
                    table[index] = current.next;
                } else {
                    // El nodo a eliminar está en medio o al final
                    prev.next = current.next;
                }
                size--;
                System.out.println("Cierre de sesión exitoso para el token: " + token);
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    // 4. Limpiar sesiones expiradas
    public void cleanExpired() {
        long currentTime = System.currentTimeMillis();
        int removedCount = 0;

        for (int i = 0; i < capacity; i++) {
            Node current = table[i];
            Node prev = null;

            while (current != null) {
                if (currentTime >= current.session.expiresAt) {
                    // La sesión expiró, eliminarla
                    if (prev == null) {
                        table[i] = current.next;
                        current = table[i]; 
                    } else {
                        prev.next = current.next;
                        current = current.next; 
                    }
                    size--;
                    removedCount++;
                } else {
                    // La sesión sigue activa, avanzar
                    prev = current;
                    current = current.next;
                }
            }
        }
        System.out.println("Limpieza completada. Sesiones expiradas eliminadas: " + removedCount);
    }

    // Método auxiliar para pruebas
    public int getActiveSessionCount() {
        return size;
    }
}