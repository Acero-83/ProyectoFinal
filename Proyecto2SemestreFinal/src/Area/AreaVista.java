package Area;

import java.util.List;

public class AreaVista {
    public void mostrarArea(List<Area> areas) {
        System.out.println("\n *** Areas ***");
        if (areas.isEmpty()) {
            System.out.println("No hay Areas que mostrar, cree una");
        } else {
            System.out.printf("%5s %15s %25s %35s\n", "CODIGO", "NOMBRE", "PRESUPUESTO", "TIPO");
            for (Area area : areas) {
                System.out.printf("%5s %15s %25s %35s\n", area.getId(), area.getNombre(), area.getPresupuesto(), area.getTipo());

            }
        }
    }
}

