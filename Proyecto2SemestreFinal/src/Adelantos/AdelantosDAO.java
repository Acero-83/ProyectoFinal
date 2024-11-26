package Adelantos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdelantosDAO {
    public Connection conexion;

    public AdelantosDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Mostrar adelantos
    public List<Adelantos> obtenerAdelantos(int idEmpleado) {
        List<Adelantos> adelantos1 = new ArrayList<Adelantos>();
        String sql = "SELECT * FROM adelanto where adelanto.id_empleado = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)
        ) {
            statement.setInt(1, idEmpleado);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double monto = resultSet.getDouble("monto");
                String motivo = resultSet.getString("motivo");
                int id_empleado = resultSet.getInt("id_empleado");
                Adelantos adelantos2 = new Adelantos(id, monto, motivo, id_empleado);
                adelantos1.add(adelantos2);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return adelantos1;
    }

    public void insertarAdelanto(double monto, String motivo, int id_empleado) {
        String sql = "INSERT INTO adelanto (monto,motivo,id_empleado) VALUES (?,?,?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setDouble(1, monto);
            statement.setString(2, motivo);
            statement.setInt(3, id_empleado);
            statement.executeUpdate();
            System.out.println("Adelanto agregado exitosamente");
        } catch (SQLException e) {
            throw new RuntimeException("Error al agregar Adelanto " + e.getMessage());
        }
    }
    }

