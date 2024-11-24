package Area;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AreaControlador {
    private AreaDAO areaDAO;
    private AreaVista areaVista;

    public AreaControlador(AreaDAO areaDAO, AreaVista areaVista) {
        this.areaDAO = areaDAO;
        this.areaVista = areaVista;
    }

    //Mostrar Areas
    public void ListarArea() {
        List<Area> area1 = areaDAO.obtenerArea();
        areaVista.mostrarArea(area1);
    }

    public void InsertarArea() throws SQLException {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Ingrese el nombre del area: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el presupuesto del area: ");
        double presupuesto = sc2.nextDouble();
        System.out.println("Seleccione el tipo de area");
        System.out.println("1. Administracion");
        System.out.println("2. Produccion");
        System.out.println("3. Finanzas");
        System.out.print("Ingrese su seleccion: ");
        int seleccion = sc3.nextInt();
        String tipo = "";
        switch (seleccion) {
            case 1:
                tipo = "Administracion";
                break;
            case 2:
                tipo = "Produccion";
                break;
            case 3:
                tipo = "Finanzas";
                break;
            default:
                System.out.println("Opcion no valida, intentelo denuevo");
                break;
        }
        areaDAO.insertarArea(nombre, presupuesto, tipo);
    }
    // Metodo para eliminar Area
    public void eliminarArea() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero del area que quiere eliminar: ");
        int id = sc.nextInt();
        areaDAO.deleteArea(id);
    }
}
