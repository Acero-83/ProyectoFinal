package Beneficios;

import java.util.List;

public class BeneficiosVista {
    public void mostrarBeneficios(List<Beneficios> beneficio1) {
        System.out.println("\n *** Beneficios ***");
        if (beneficio1.isEmpty()) {
            System.out.println("No hay Beneficios que mostrar, cree una");
        } else {
            System.out.printf("%5s %15s %25s %35s\n", "CODIGO", "NOMBRE", "PRESUPUESTO", "TIPO");
            for (Beneficios beneficios : beneficio1) {
                System.out.printf("%5s %15s %25s %35s\n", beneficios.getId(), beneficios.getNombre(), beneficios.getPrecio(),beneficios.getLugarSeguro());

            }
        }
    }
}
