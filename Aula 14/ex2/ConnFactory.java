import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnFactory { 
    private static final String URL = "jdbc:mysql://localhost:3306/db_materia"; 
    private static final String USER = "root"; 
    private static final String PASS = "tinCTrom"; 
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; 
    private static final String ERROBD = "Erro na conexão com o Banco de Dados: "; 

    public static Connection getConn() { 
        try {
            Class.forName(DRIVER); 
            return DriverManager.getConnection(URL, USER, PASS); 
        } catch (ClassNotFoundException | SQLException e) { 
            throw new RuntimeException(ERROBD + e); 
        }
    }
}