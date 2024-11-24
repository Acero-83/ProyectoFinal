package Empleados;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadosDAO {
    public Connection conexion;

    public EmpleadosDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public List<Empleados> obtenerEmpleaods(int id_puesto) {
        List<Empleados> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleado JOIN puesto ON empleado.id_puesto=puesto.id WHERE empleado.id_puesto = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id_puesto);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String apellido1 = resultSet.getString("apellido1");
                String apellido2 = resultSet.getString("apellido2");
                int edad = resultSet.getInt("edad");
                int id_puesto1 = resultSet.getInt("id_puesto");
                int id_beneficio = resultSet.getInt("id_beneficios");
                Empleados empleados1 = new Empleados(id, nombre, apellido1, apellido2, edad, id_puesto1, id_beneficio);
                empleados.add(empleados1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empleados;
    }

    public void insertarEmpleado(String nombre, String apellido1,String apellido2,
                                 int edad, int id_puesto, int id_beneficio) {
        String sql = "INSERT INTO empleado (nombre,apellido1,apellido2,edad,id_puesto,id_beneficios) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, apellido1);
            statement.setString(3, apellido2);
            statement.setInt(4, edad);
            statement.setInt(5, id_puesto);
            statement.setInt(6, id_beneficio);
            statement.executeUpdate();
            System.out.println("Empleado agregado exitosamente");
        } catch (SQLException e) {
            throw new RuntimeException("Error al agregar Puesto " + e.getMessage());
        }
    }
}
