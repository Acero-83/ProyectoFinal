package Puesto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PuestoControlador {
    private PuestoDAO puestoDAO;
    private PuestoVista puestoVista;

    public PuestoControlador(PuestoDAO puestoDAO, PuestoVista puestoVista) {
        this.puestoDAO = puestoDAO;
        this.puestoVista = puestoVista;
    }

    // Mostrar puestos
    public void ListarPuestos(int idPuestos) throws SQLException {
        List<Puesto> listaPuestos = puestoDAO.obtenerPuestos(idPuestos);
        puestoVista.mostrarPuestos(listaPuestos);
    }

    public void CrearPuesto(int IdArea) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Ingrese el nombre del puesto: ");
        String nombre = sc.nextLine();
        System.out.println("Seleccione el tipo de puesto");
        System.out.println("1. Gerente");
        System.out.println("2. Jefe");
        System.out.println("3. Subgerente");
        System.out.println("4. Vendedor");
        System.out.println("5.Operario");
        System.out.println("6. Asitente");
        System.out.print("Ingrese su seleccion: ");
        int seleccion = sc3.nextInt();
        String tipo = "";
        switch (seleccion) {
            case 1:
                tipo = "Gerente";
                break;
            case 2:
                tipo = "Jefe";
                break;
            case 3:
                tipo = "Subgerente";
                break;
            case 4:
                tipo = "Vendedor";
                break;
            case 5:
                tipo = "Asitente";
                break;
            case 6:
                tipo = "Gerente";
                break;
            default:
                System.out.println("Opcion no valida, intentelo denuevo");
                break;
        }
        System.out.println("Ingrese el sueldo del area: ");
        double sueldo = sc2.nextDouble();
        int id_area=IdArea;
        puestoDAO.insertarPuesto(nombre, tipo, sueldo, id_area);
    }
    public void eliminarPuesto() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el codigo del puesto que quiere eliminar: ");
        int id = sc.nextInt();
        puestoDAO.eliminarPuesto(id);
    }
}
