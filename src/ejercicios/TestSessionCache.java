package ejercicios;

public class TestSessionCache {
    public static void main(String[] args) {
        // Inicializamos el caché
        SesionCache cache = new SesionCache(16);

        System.out.println("--- 1. INICIANDO SESIONES ---");
        cache.login("abc123", "alice_admin", "ADMIN", 5000);
        cache.login("xyz789", "bob_user", "USER", 1000);
        cache.login("qwerty456", "charlie_user", "USER", 10000);
        System.out.println("Sesiones activas registradas: " + cache.getActiveSessionCount());

        System.out.println("\n--- SIMULANDO PASO DEL TIEMPO (Esperando 1.5 segundos) ---");
        try {
            Thread.sleep(1500); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n--- 2. VALIDANDO TOKENS ---");
        Sesion session1 = cache.validate("abc123");
        System.out.println("Validando 'abc123' (Alice): " + (session1 != null ? "ACTIVA -> " + session1 : "EXPIRADA/INVÁLIDA"));

        Sesion session2 = cache.validate("xyz789");
        System.out.println("Validando 'xyz789' (Bob): " + (session2 != null ? "ACTIVA -> " + session2 : "EXPIRADA/INVÁLIDA"));

        System.out.println("\n--- 3. CIERRE DE SESIÓN EXPLÍCITO ---");
        cache.logout("qwerty456");

        System.out.println("\n--- 4. LIMPIANDO SESIONES EXPIRADAS (cleanExpired) ---");
        System.out.println("Sesiones en el sistema antes de limpiar: " + cache.getActiveSessionCount());
        cache.cleanExpired();
        System.out.println("Sesiones activas restantes: " + cache.getActiveSessionCount());
    }
}