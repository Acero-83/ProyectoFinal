package Adelantos;
import DataBase.ConnectionDB;
import Empleados.EmpleadoVista;
import Empleados.EmpleadosControlador;
import Empleados.EmpleadosDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static DataBase.ConnectionDB.conexion;

public class MenuAdelantos {
    private AdelantosDAO adelantosDAO = new AdelantosDAO(conexion);
    private AdelantosVista adelantosVista = new AdelantosVista();
    AdelantosControlador adelantosControlador = new AdelantosControlador(adelantosDAO, adelantosVista);
    private EmpleadosDAO empleadosDAO = new EmpleadosDAO(conexion);
    private EmpleadoVista empleadoVista= new EmpleadoVista();
    private EmpleadosControlador empleadosControlador = new EmpleadosControlador(empleadosDAO, empleadoVista);

    public void menuAdelantos(int MostrarEmpleados) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Scanner in = new Scanner(System.in);
        int option;
        do {
            System.out.println("-------------------- MENU ADELANTOS --------------------");
            System.out.println("1. VER ADELANTOS DE EMPLEADO");
            System.out.println("2. CREAR ADELANTOS DE EMPLEADO");
            System.out.println("3. SALIR");
            System.out.println("Ingrese su eleccion ");
            option = in.nextInt();
            switch (option){
                case 1:
                    empleadosControlador.ListarEmpleados(MostrarEmpleados);
                    System.out.println("Ingrese el codigo del empleado");
                    int codigoEmpleado = in.nextInt();
                    adelantosControlador.listarAdelantos(codigoEmpleado);
                    break;
                    case 2:
                        empleadosControlador.ListarEmpleados(MostrarEmpleados);
                        System.out.println("Ingrese el codigo del empleado");
                        int codigoEmpleado2 = in.nextInt();
                        adelantosControlador.agregarAdelanto(codigoEmpleado2);
                case 3:
                    System.out.println("Saliendo del Menu...");
                    break;
                default:
                    System.out.println("Opcion no valida, intentelo denuevo");
                    break;
            }
        } while (option !=3);
    }
}
