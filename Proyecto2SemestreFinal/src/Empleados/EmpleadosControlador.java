package Empleados;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EmpleadosControlador {
    Connection con;
    private EmpleadosDAO empleadosDAO ;
    private EmpleadoVista empleadoVista;

    public EmpleadosControlador(EmpleadosDAO empleadosDAO, EmpleadoVista empleadoVista) {
        this.empleadosDAO = empleadosDAO;
        this.empleadoVista = empleadoVista;
    }
    public void metodo() {
        if (empleadosDAO != null) {
            empleadosDAO.obtenerEmpleaods(1);
        } else {
            System.out.println("empleadosDAO no ha sido inicializado.");
        }
    }

    // Mostrar empleados
    public void ListarEmpleados(int idEmpleados) throws SQLException {
        List<Empleados> listaempleados = empleadosDAO.obtenerEmpleaods(idEmpleados);
        empleadoVista.mostrarEmpleados(listaempleados);
    }

    public void CrearEmpleado(int IdPuesto) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Ingrese el nombre del empleado: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el primer apellido del empleado: ");
        String apellido1 = sc.nextLine();
        System.out.println("Ingrese el segundo apellido del empleado: ");
        String apellido2 = sc3.nextLine();
        System.out.println("Ingrese la edad del empleado: ");
        int edad = sc2.nextInt();
        System.out.println("Ingrese el numero del subsidio empleado: ");
        int subsidio = sc2.nextInt();
        int idPuestos = IdPuesto;
        empleadosDAO.insertarEmpleado(nombre,apellido1,apellido2,edad,idPuestos,subsidio);
    }
}