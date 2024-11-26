package Descuentos;

import java.util.List;
import java.util.Scanner;

public class DescuentosControlador {
    private DescuentosDAO descuentosDAO;
    private DescuentosVista descuentosVista;

    public DescuentosControlador(DescuentosDAO descuentosDAO, DescuentosVista descuentosVista) {
        this.descuentosDAO = descuentosDAO;
        this.descuentosVista = descuentosVista;
    }
    public void  listarDescuento(int idEmpleado){
        List<Descuentos> descuentosList = descuentosDAO.obtenerdescuentos(idEmpleado);
        descuentosVista.mostrarDescuentos(descuentosList);
    }
    public void agregarDescuento(int iddescuento){
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Ingrese el monto del descuento");
        double monto = sc.nextDouble();
        System.out.println("Ingrese el motivo del descuento");
        String motivo = sc2.nextLine();
        int id_empleado=iddescuento;
        descuentosDAO.insertarDescuento(monto,motivo,id_empleado);
    }
}
