package Beneficios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BeneficiosDAO {
    public Connection conexion;

    public BeneficiosDAO(Connection conexion) {
        this.conexion = conexion;
    }
    // Mostrar Beneficios
    public List<Beneficios> obtenerBeneficios() {
        List<Beneficios> beneficios1 = new ArrayList<Beneficios>();
        String sql = "SELECT * FROM beneficios";
        try (PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                double montoBeneficio = resultSet.getDouble("montoBeneficio");
                String LugarSeguro = resultSet.getString("LugarDeSeguro");
                Beneficios beneficios2 = new Beneficios(id, nombre, montoBeneficio, LugarSeguro);
                beneficios1.add(beneficios2);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return beneficios1;
    }
    public void insertarBeneficio(String nombre, double montoBeneficio, String LugarDeSeguro) {
        String sql = "INSERT INTO beneficios (nombre,montoBeneficio,LugarDeSeguro) VALUES (?,?,?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setDouble(2, montoBeneficio);
            statement.setString(3, LugarDeSeguro);
            statement.executeUpdate();
            System.out.println("Beneficios creada exitosamente");
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear beneficios" + e.getMessage());
        }
    }
}
