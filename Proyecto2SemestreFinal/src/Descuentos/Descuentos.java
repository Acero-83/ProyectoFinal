package Descuentos;

public class Descuentos {
    private int id;
    private double monto;
    private String motivo;
    private int id_empleado;

    public Descuentos(int id, double monto, String motivo, int id_empleado) {
        this.id = id;
        this.monto = monto;
        this.motivo = motivo;
        this.id_empleado = id_empleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }
}
