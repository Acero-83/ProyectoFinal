package Adelantos;

import java.util.List;
import java.util.Scanner;

public class AdelantosControlador {
    private AdelantosDAO adelantosDAO;
    private AdelantosVista adelantosVista;

    public AdelantosControlador(AdelantosDAO adelantosDAO,AdelantosVista adelantosVista) {
        this.adelantosDAO = adelantosDAO;
        this.adelantosVista = adelantosVista;
    }
    public void  listarAdelantos(int idEmpleado){
        List <Adelantos>  adelantosList = adelantosDAO.obtenerAdelantos(idEmpleado);
        adelantosVista.mostrarAdelantos(adelantosList);
    }
    public void agregarAdelanto(int idAdelanto){
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Ingrese el monto del adelanto");
        double monto = sc.nextDouble();
        System.out.println("Ingrese el motivo del adelanto");
        String motivo = sc2.nextLine();
        int id_empleado=idAdelanto;
        adelantosDAO.insertarAdelanto(monto,motivo,id_empleado);
    }

}
