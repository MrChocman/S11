package Actividades;

// Register class to represent a user registration
public class Register {
    private int key;// Unique identifier for the registration
    private String name;//Nombre del usuario registrado
// Constructor para inicializar los campos de la clase Register
    public Register(int key, String name) {
        this.key = key;
        this.name = name;    }
//Retorna el valor de la clave única del registro
    public int getKey() {
        return key;
    }
//Retorna el nombre del usuario registrado
    public String getName() {
        return name;
    }
// Método para representar el objeto Register como una cadena de texto
public String ToString() {
        return "("+key + ", " + name + ")";
    }
}