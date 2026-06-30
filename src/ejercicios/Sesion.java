package ejercicios;

public class Sesion {
    String token;
    String username;
    String role;
    long expiresAt;

    public Sesion(String token, String username, String role, long expiresAt) {
        this.token = token;
        this.username = username;
        this.role = role;
        this.expiresAt = expiresAt;
    }

    @Override
    public String toString() {
        return "Session{" +
                "username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", expiresAt=" + expiresAt +
                '}';
    }
}