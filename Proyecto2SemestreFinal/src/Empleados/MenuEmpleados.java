package Empleados;


import Adelantos.AdelantosControlador;
import Adelantos.AdelantosDAO;
import Adelantos.AdelantosVista;
import Adelantos.MenuAdelantos;
import Beneficios.BeneficiosControlador;
import Beneficios.BeneficiosDAO;
import Beneficios.BeneficiosVista;
import DataBase.ConnectionDB;
import Descuentos.DescuentosControlador;
import Descuentos.DescuentosDAO;
import Descuentos.DescuentosVista;
import Descuentos.MenuDesc;

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
    private AdelantosDAO adelantosDAO = new AdelantosDAO(conexion);
    private AdelantosVista adelantosVista = new AdelantosVista();
    AdelantosControlador adelantosControlador = new AdelantosControlador(adelantosDAO, adelantosVista);
    MenuAdelantos menuAdelantos = new MenuAdelantos();
    private DescuentosDAO descuentosDAO=new DescuentosDAO(conexion);
    private DescuentosVista descuentosVista= new DescuentosVista();
    DescuentosControlador descuentosControlador = new DescuentosControlador(descuentosDAO,descuentosVista);
    MenuDesc menuDesc = new MenuDesc();

    public void menu1Empleado(int MostrarEmpleados) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Scanner in = new Scanner(System.in);
        int option;
        do {
            empleadosControlador.ListarEmpleados(MostrarEmpleados);
            System.out.println("-------------------- MENU EMPLEADOS --------------------");
            System.out.println("1. AGREGAR EMPLEADO");
            System.out.println("2. VER SUBSIDIO");
            System.out.println("3. MENU DESCUENTO");
            System.out.println("4. MENU ADELANTO");
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
                    menuDesc.menuDescuento(MostrarEmpleados);
                    break;
                case 4:
                    menuAdelantos.menuAdelantos(MostrarEmpleados);
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
