package Puesto;

import DataBase.ConnectionDB;
import Empleados.EmpleadoVista;
import Empleados.EmpleadosControlador;
import Empleados.EmpleadosDAO;
import Empleados.MenuEmpleados;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static DataBase.ConnectionDB.conexion;

public class Menu1Puesto {
    private EmpleadosDAO empleadosDAO = new EmpleadosDAO(conexion);
    private EmpleadoVista empleadoVista= new EmpleadoVista();
    private EmpleadosControlador empleadosControlador = new EmpleadosControlador(empleadosDAO, empleadoVista);

    private PuestoDAO puestoDAO = new PuestoDAO(conexion);
    private PuestoVista puestoVista = new PuestoVista();
    PuestoControlador puestoControlador = new PuestoControlador(puestoDAO, puestoVista);
    MenuEmpleados menuEmpleados = new MenuEmpleados();

    public void menu1Puesto(int MostrarPuesto) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Scanner in = new Scanner(System.in);
        int option;
        do {
            puestoControlador.ListarPuestos(MostrarPuesto);
            System.out.println("-------------------- MENU PUESTO --------------------");
            System.out.println("1. VER EMPLEADOS DEL PUESTO");
            System.out.println("2. CREAR PUESTO");
            System.out.println("3. ELIMINAR PUESTO");
            System.out.println("4. SALIR");
            System.out.print("Escribe la opcion que seleccionaste: ");
            option = in.nextInt();
            switch (option) {
                case 1:
                    puestoControlador.ListarPuestos(MostrarPuesto);
                    System.out.print("Ingrese el id del puesto al que quiere ingresar: ");
                    int id1 = in.nextInt();
                    empleadosControlador.ListarEmpleados(id1);
                    menuEmpleados.menu1Empleado(id1);
                    break;
                case 2:
                    puestoControlador.CrearPuesto(MostrarPuesto);
                    break;
                case 3:
                    puestoControlador.eliminarPuesto();
                    break;
                case 4:
                    System.out.println("Saliendo del Menu...");
                    break;
                default:
                    System.out.println("Opcion no valida, intentelo denuevo");
                    break;
            }
        } while (option != 4);
    }
}
