package Descuentos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DescuentosDAO {
    public Connection conexion;

    public DescuentosDAO(Connection conexion) {
        this.conexion = conexion;
    }
    public List<Descuentos> obtenerdescuentos(int idEmpleado) {
        List<Descuentos> descuentos1 = new ArrayList<Descuentos>();
        String sql = "SELECT * FROM descuentos where descuentos.id_empleado = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)
        ) {
            statement.setInt(1, idEmpleado);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double monto = resultSet.getDouble("monto");
                String motivo = resultSet.getString("motivo");
                int id_empleado = resultSet.getInt("id_empleado");
                Descuentos descuentos2 = new Descuentos(id, monto, motivo, id_empleado);
                descuentos1.add(descuentos2);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return descuentos1;
    }

    public void insertarDescuento(double monto, String motivo, int id_empleado) {
        String sql = "INSERT INTO descuentos (monto,motivo,id_empleado) VALUES (?,?,?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setDouble(1, monto);
            statement.setString(2, motivo);
            statement.setInt(3, id_empleado);
            statement.executeUpdate();
            System.out.println("Descuento agregado exitosamente");
        } catch (SQLException e) {
            throw new RuntimeException("Error al agregar Descuento " + e.getMessage());
        }
    }
}
