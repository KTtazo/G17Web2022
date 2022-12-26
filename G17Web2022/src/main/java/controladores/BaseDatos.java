package controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDatos {

    private Connection connection;
    private Statement statement;
    private ResultSet rs;
    
    private static BaseDatos instancia; //Patron Singleton
    
    private BaseDatos(){ 
    }
    
    public static BaseDatos getInstancia(){
        if (instancia == null){
            instancia = new BaseDatos();
        }
        return instancia;
    }
    
    public Connection getConnection() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/gestionPracticas?useTimezone=true&serverTimezone=Europe/Madrid";
        String user = "root";
        String password = "root";
        System.out.println("Entramos a conectar con la BBDD");
        if (connection != null) {
            System.out.println("Ya hay una conexion");
            return connection;
        } else {
            try {
                System.out.println("Creamos una nueva conexion");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Finalizamos config db");
            } catch (ClassNotFoundException e) {
                System.out.println("Error de conexion: " + e);
            } catch (SQLException e) {
                System.out.println("Error de SQL: " + e);
            } catch (Exception e) {
                System.out.println("Error general DB: " + e);
            }

            return connection;
        }
    }
    
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexion: " + e);
        }
    }
}
