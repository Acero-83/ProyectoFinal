package Empleados;


import Beneficios.BeneficiosControlador;
import Beneficios.BeneficiosDAO;
import Beneficios.BeneficiosVista;
import DataBase.ConnectionDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static DataBase.ConnectionDB.conexion;

public class MenuEmpleados {
    private BeneficiosDAO beneficiosDAO = new BeneficiosDAO(conexion);
    private BeneficiosVista beneficiosVista =  new BeneficiosVista();
   BeneficiosControlador beneficiosControlador = new BeneficiosControlador(beneficiosDAO, beneficiosVista);
    private EmpleadosDAO empleadosDAO = new EmpleadosDAO(conexion);
    private EmpleadoVista empleadoVista = new EmpleadoVista();
    EmpleadosControlador empleadosControlador = new EmpleadosControlador(empleadosDAO, empleadoVista);

    public void menu1Empleado(int MostrarEmpleados) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Scanner in = new Scanner(System.in);
        int option;
        do {
            empleadosControlador.ListarEmpleados(MostrarEmpleados);
            System.out.println("-------------------- MENU EMPLEADOS --------------------");
            System.out.println("1. AGREGAR EMPLEADO");
            System.out.println("2. VER SUBSIDIO");
            System.out.println("3. AGREGAR DESCUENTO");
            System.out.println("4. AGREGAR ADELANTO");
            System.out.println("5. SALIR");
            System.out.print("Escribe la opcion que seleccionaste: ");
            option = in.nextInt();
            switch (option) {
                case 1:
                    beneficiosControlador.InsertarBeneficio();
                    beneficiosControlador.ListarBeneficios();
                    empleadosControlador.CrearEmpleado(MostrarEmpleados);
                    break;
                case 2:
                    beneficiosControlador.ListarBeneficios();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Saliendo del Menu...");
                    break;
                default:
                    System.out.println("Opcion no valida, intentelo denuevo");
                    break;
            }
        } while (option != 5);
    }
}
