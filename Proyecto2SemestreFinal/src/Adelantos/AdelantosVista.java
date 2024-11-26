package Adelantos;

import java.util.List;

public class AdelantosVista {
    public void mostrarAdelantos(List<Adelantos> adelantos) {
        System.out.println("\n *** Adelantos ***");
        if (adelantos.isEmpty()) {
            System.out.println("No hay Adelantos que mostrar, cree una");
        } else {
            System.out.printf("%5s %15s %25s %35s \n", "CODIGO", "MONTO", "MOTIVO", "CODIGO EMPLEADO");
            for (Adelantos adelantos1 : adelantos) {
                System.out.printf("%5s %15s %25s %35s \n", adelantos1.getId(),adelantos1.getMonto(),adelantos1.getMotivo(),adelantos1.getId_empleado() );
            }
        }
    }
}
