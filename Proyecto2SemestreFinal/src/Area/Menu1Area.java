package Area;

import DataBase.ConnectionDB;
import Puesto.Menu1Puesto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


public class Menu1Area {

    public void menu1Area() throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        MenuArea2 menuArea2 = new MenuArea2();
        Menu1Puesto menu1Puesto = new Menu1Puesto();
        AreaDAO areaDAO = new AreaDAO(connection);
        AreaVista areaVista = new AreaVista();
        AreaControlador areaControlador = new AreaControlador(areaDAO, areaVista);
        Scanner in = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        int option;
        do {
            System.out.println("-------------------- MENU PRINCIPAL RRHH--------------------");
            System.out.println("1. VER AREAS E INGRESAR ");
            System.out.println("2. OTRAS OPCIONES");
            System.out.println("3. SALIR");
            System.out.print("Escribe la opcion que seleccionaste: ");
            option = in.nextInt();
            switch (option) {
                case 1:
                    areaControlador.ListarArea();
                    System.out.print("Ingrese el ID del area al que quiere ingresar: ");
                    int idPuesto = scan.nextInt();
                    menu1Puesto.menu1Puesto(idPuesto);
                    break;
                case 2:
                    menuArea2.menu2Area();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida, intentelo denuevo");
                    break;
            }
        } while (option != 3);
    }
}
