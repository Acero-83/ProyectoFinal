package Puesto;

public class Puesto {
    private int id;
    private String nombre;
    private String tipo;
    private double sueldo;
    private int idArea;

    public Puesto(int id, String nombre, String tipo, double sueldo, int idArea) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.idArea = idArea;
        this.sueldo = sueldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }
}
