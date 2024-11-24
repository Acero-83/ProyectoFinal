package Beneficios;

public class Beneficios {
    int id;
    String nombre;
    double precio;
    String lugarSeguro;

    public Beneficios(int id, String nombre, double precio, String lugarSeguro) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.lugarSeguro = lugarSeguro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugarSeguro() {
        return lugarSeguro;
    }

    public void setLugarSeguro(String lugarSeguro) {
        this.lugarSeguro = lugarSeguro;
    }
}
