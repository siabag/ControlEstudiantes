package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDaoJDBC {

    private static final String SQL_SELECT
            = "SELECT id_estudiante, nombre, apellido, email, telefono, edad FROM "
            + "estudiantes";

    private static final String SQL_SELECT_BY_ID
            = "SELECT id_estudiante, nombre, apellido, email, telefono, edad FROM estudiantes "
            + "WHERE "
            + "id_estudiante=?";

    private static final String SQL_INSERT
            = "INSERT INTO estudiantes(nombre, apellido, email, telefono, edad) "
            + "VALUES(?,?,?,?,?)";

    private static final String SQL_UPDATE
            = "UPDATE estudiantes SET nombre=?, apellido=?, email=?, telefono=?, edad=? "
            + "WHERE id_estudiante=?";

    private static final String SQL_DELETE
            = "DELETE FROM estudiantes WHERE id_estudiante=?";

    //Metodo para obtener la lista completa de estudiantes
    public List<Estudiante> listar() {
        List<Estudiante> estudiantes = new ArrayList<>();
        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idEstudiante = rs.getInt("id_estudiante");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double edad = rs.getDouble("edad");

                Estudiante estudiante = new Estudiante(idEstudiante, nombre, apellido, email, telefono, edad);
                estudiantes.add(estudiante);
            }
        } catch (Exception e) {
            System.out.println("Error al listar estudiantes " + e.getMessage());
        }
        return estudiantes;
    }

    public int insertar(Estudiante estudiante) {
        int rows = 0;
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {
            stmt.setString(1, estudiante.getNombre());
            stmt.setString(2, estudiante.getApellido());
            stmt.setString(3, estudiante.getEmail());
            stmt.setString(4, estudiante.getTelefono());
            stmt.setDouble(5, estudiante.getEdad());
            rows = stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar estudiante " + e.getMessage());
        }
        return rows;
    }

    public int actualizar(Estudiante estudiante) {
        int rows = 0;
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE)) {
            stmt.setString(1, estudiante.getNombre());
            stmt.setString(2, estudiante.getApellido());
            stmt.setString(3, estudiante.getEmail());
            stmt.setString(4, estudiante.getTelefono());
            stmt.setDouble(5, estudiante.getEdad());
            stmt.setInt(6, estudiante.getIdEstudiante());
            rows = stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar estudiante " + e.getMessage());
        }
        return rows;
    }

    public int eliminar(Estudiante estudiante) {
        int rows = 0;
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_DELETE)) {
            stmt.setInt(1, estudiante.getIdEstudiante());
            rows = stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar estudiante " + e.getMessage());
        }
        return rows;
    }

    public Estudiante buscar(Estudiante estudian) {
        Estudiante estudiante = new Estudiante(estudian.getIdEstudiante());
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_BY_ID)) {
            stmt.setInt(1, estudian.getIdEstudiante());
            ResultSet rs = stmt.executeQuery();
            int idEstudiante = rs.getInt("id_estudiante");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            double edad = rs.getDouble("edad");

            Estudiante estudiant = new Estudiante(idEstudiante, nombre, apellido, email, telefono, edad);
            return estudiant;
        } catch (Exception e) {
            System.out.println("Error al buscar estudiante " + e.getMessage());
        }
        return estudiante;
    }
}
