package Empleados;

public class Empleados {
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    private int id_puesto;
    private int id_beneficios;

    public Empleados(int id, String nombre, String apellido1, String apellido2, int edad, int id_puesto, int id_beneficios) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
        this.id_puesto = id_puesto;
        this.id_beneficios = id_beneficios;
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

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }

    public int getId_beneficios() {
        return id_beneficios;
    }

    public void setId_beneficios(int id_beneficios) {
        this.id_beneficios = id_beneficios;
    }
}
