package Puesto;

import java.awt.geom.Area;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PuestoDAO {
    public Connection conexion;

    public PuestoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Mostrar puestos
    public List<Puesto> obtenerPuestos(int id_area) {
        List<Puesto> puestos = new ArrayList<>();
        String sql = "SELECT * FROM puesto JOIN area1 ON puesto.id_area=area1.id WHERE puesto.id_area = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id_area);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String tipo = resultSet.getString("tipo");
                Double sueldo = resultSet.getDouble("sueldo");
                int id_area1 = resultSet.getInt("id_area");
                Puesto puesto1 = new Puesto(id, nombre, tipo, sueldo, id_area1);
                puestos.add(puesto1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return puestos;
    }

    // Crear Puestos
    public void insertarPuesto(String nombre, String tipo, Double sueldo, int id_area) {
        String sql = "INSERT INTO puesto (nombre,tipo, sueldo, id_area) VALUES (?,?,?,?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, tipo);
            statement.setDouble(3, sueldo);
            statement.setInt(4, id_area);
            statement.executeUpdate();
            System.out.println("Puesto creada exitosamente");
        } catch (SQLException e) {
            throw new RuntimeException("Error al agregar Puesto " + e.getMessage());
        }

    }
    // eliminar puestos
    public void eliminarPuesto(int id) {
        String sql = "DELETE FROM puesto WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar area" + e.getMessage());
        }
    }
    }

