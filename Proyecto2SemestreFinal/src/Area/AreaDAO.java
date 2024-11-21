package Area;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AreaDAO {
    public Connection conexion;

    public AreaDAO(Connection conexion) {

        this.conexion = conexion;
    }

    // Mostrar areas
    public List<Area> obtenerArea() {
        List<Area> area1 = new ArrayList<Area>();
        String sql = "SELECT * FROM area1";
        try (PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                double presupuesto = resultSet.getDouble("presupuesto");
                String tipo = resultSet.getString("tipo");
                Area area2 = new Area(id, nombre, presupuesto, tipo);
                area1.add(area2);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return area1;
    }

    public void insertarArea(String nombre, double presupuesto, String tipo) {
        String sql = "INSERT INTO area1 (nombre,presupuesto,tipo) VALUES (?,?,?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setDouble(2, presupuesto);
            statement.setString(3, tipo);
            statement.executeUpdate();
            System.out.println("Area creada exitosamente");
        } catch (SQLException e) {
            throw new RuntimeException("Error al agregar area" + e.getMessage());
        }
    }
    public void deleteArea(int id) {
        String sql = "DELETE FROM area1 WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar area" + e.getMessage());
        }
    }
}
