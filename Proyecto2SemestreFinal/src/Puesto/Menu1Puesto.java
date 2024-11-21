package Puesto;

import DataBase.ConnectionDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static DataBase.ConnectionDB.conexion;

public class Menu1Puesto {

    private PuestoDAO puestoDAO = new PuestoDAO(conexion);
    private PuestoVista puestoVista = new PuestoVista();
    PuestoControlador puestoControlador = new PuestoControlador(puestoDAO, puestoVista);

    public void menu1Puesto(int MostrarPuesto) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Scanner in = new Scanner(System.in);
        int option;
        do {
            puestoControlador.ListarPuestos(MostrarPuesto);
            System.out.println("-------------------- MENU PUESTO --------------------");
            System.out.println("1. CREAR PUESTO");
            System.out.println("2. ELIMINAR PUESTO");
            System.out.println("3. SALIR");
            System.out.print("Escribe la opcion que seleccionaste: ");
            option = in.nextInt();
            switch (option) {
                case 1:
                    puestoControlador.CrearPuesto(MostrarPuesto);
                    break;
                case 2:
                    puestoControlador.eliminarPuesto();
                    break;
                case 3:
                    System.out.println("Saliendo del Menu...");
                    connection.close();
                    break;
                default:
                    System.out.println("Opcion no valida, intentelo denuevo");
                    break;
            }
        } while (option != 3);
    }
}
