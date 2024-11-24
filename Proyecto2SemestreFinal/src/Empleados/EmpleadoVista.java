package Empleados;


import java.util.List;

public class EmpleadoVista {
    public void mostrarEmpleados(List<Empleados> empleados) {
        System.out.println("\n *** Empleados ***");
        if (empleados.isEmpty()) {
            System.out.println("No hay Empleados que mostrar, agregue uno");
        } else {
            System.out.printf("%5s %15s %25s %35s %45s %55s %65s\n", "CODIGO", "NOMBRE", "APELLIDO PAT.", "APELLIDO MAT",
                    "EDAD","CODIGO BENEFICIO", "CODIGO PUESTO");
            for (Empleados empleados1: empleados) {
                System.out.printf("%5s %15s %25s %35s %45s %55s %65s \n", empleados1.getId(),
                        empleados1.getNombre(),empleados1.getApellido1(),
                        empleados1.getApellido2(),empleados1.getEdad(),empleados1.getId_beneficios(),empleados1.getId_puesto());
            }
        }
    }
}
