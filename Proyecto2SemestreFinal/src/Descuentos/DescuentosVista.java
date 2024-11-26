package Descuentos;


import java.util.List;

public class DescuentosVista {
    public void mostrarDescuentos(List<Descuentos> descuentos) {
        System.out.println("\n *** DESCUENTOS ***");
        if (descuentos.isEmpty()) {
            System.out.println("No hay Descuentos que mostrar, cree una");
        } else {
            System.out.printf("%5s %15s %25s %35s \n", "CODIGO", "MONTO", "MOTIVO", "CODIGO EMPLEADO");
            for (Descuentos descuentos1 : descuentos) {
                System.out.printf("%5s %15s %25s %35s \n", descuentos1.getId(),descuentos1.getMonto(),descuentos1.getMotivo(),descuentos1.getId_empleado() );
            }
        }
    }
}
