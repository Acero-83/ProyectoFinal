package Area;

import DataBase.ConnectionDB;
import Puesto.Menu1Puesto;
import Puesto.PuestoControlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static DataBase.ConnectionDB.conexion;

public class MenuArea2 {

    private AreaDAO areaDAO = new AreaDAO(conexion);
    private AreaVista areaVista = new AreaVista();
    AreaControlador areaControlador = new AreaControlador(areaDAO, areaVista);

    public void menu2Area() throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        Scanner in = new Scanner(System.in);
        int option;
        do {
            System.out.println("-------------------- MENU AREA --------------------");

            System.out.println("1. CREAR AREA");
            System.out.println("2. ELIMINAR AREA");
            System.out.println("3. SALIR");
            System.out.print("Escribe la opcion que seleccionaste: ");
            option = in.nextInt();
            switch (option) {
                case 1:
                    areaControlador.InsertarArea();
                    break;
                case 2:
                    areaControlador.ListarArea();
                    areaControlador.eliminarArea();
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
