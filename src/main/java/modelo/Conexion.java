
package modelo;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.*;


public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/control_estudiantes_ucoltis?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrival=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";
    private static BasicDataSource dataSource;
    
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("No se pudo cargar el driver" + e.getMessage());
        }
    }
    
    private static DataSource getDataSource(){
        if(dataSource == null){
            dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASSWORD);
            dataSource.setInitialSize(50);
        }
        return dataSource;
    }
    
    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection();
    }
    
    public static void Close(ResultSet rs){
        try {
            rs.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
    public static void Close(PreparedStatement ps){
        try {
            ps.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
    public static void Close(Connection conn){
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
