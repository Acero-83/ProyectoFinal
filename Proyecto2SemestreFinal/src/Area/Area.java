package Area;

public class Area {
    private int id;
    private String nombre;
    private double presupuesto;
    private String tipo;

    public Area(int id) {
        this.id = id;
    }

    public Area(int id, String nombre, double presupuesto, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.tipo = tipo;
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

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
