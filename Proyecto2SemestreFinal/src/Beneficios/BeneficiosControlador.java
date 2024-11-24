package Beneficios;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BeneficiosControlador {
    private BeneficiosDAO beneficiosDAO;
    private BeneficiosVista beneficiosVista;

    public BeneficiosControlador(BeneficiosDAO beneficiosDAO, BeneficiosVista beneficiosVista) {
        this.beneficiosDAO = beneficiosDAO;
        this.beneficiosVista = beneficiosVista;
    }

    public void ListarBeneficios() {
        List<Beneficios> beneficios1 = beneficiosDAO.obtenerBeneficios();
        beneficiosVista.mostrarBeneficios(beneficios1);
    }

    public void InsertarBeneficio() throws SQLException {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Ingrese el nombre del Beneficio: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el monto del Beneficio: ");
        double montoBeneficio = sc2.nextDouble();
        System.out.println("Ingrese el Lugar del Sguro");
        String lugar = sc.nextLine();
        beneficiosDAO.insertarBeneficio(nombre, montoBeneficio, lugar);
    }
}
