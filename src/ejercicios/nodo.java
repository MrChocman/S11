package ejercicios;

public class nodo {
    private int clave;
    private String nombre;

    public nodo(int c, String n) { 
        this.clave = c; 
        this.nombre = n; 
    }

    public int getclave(){return this.clave;}
    public String getname(){return this.nombre;}
}
