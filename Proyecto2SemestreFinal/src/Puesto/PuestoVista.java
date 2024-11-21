package Puesto;


import java.util.List;

public class PuestoVista {
    public void mostrarPuestos(List<Puesto> puestos) {
        System.out.println("\n *** Puestos ***");
        if (puestos.isEmpty()) {
            System.out.println("No hay Puestos que mostrar, cree una");
        } else {
            System.out.printf("%5s %15s %25s %35s %45s \n", "CODIGO", "NOMBRE", "TIPO", "SUELDO", "COD.AREA");
            for (Puesto puesto : puestos) {
                System.out.printf("%5s %15s %25s %35s %45s \n", puesto.getId(), puesto.getNombre(), puesto.getTipo(), puesto.getSueldo(), puesto.getIdArea());
            }
        }
    }
}
