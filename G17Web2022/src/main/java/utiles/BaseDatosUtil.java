package utiles;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelos.Persona;

public class BaseDatosUtil {

    private Connection conexion;
    private Statement statement;
    PreparedStatement ps;
    private ResultSet rs;

    private static BaseDatosUtil instancia; //Patron Singleton

    private BaseDatosUtil() {
    }

    public static BaseDatosUtil getInstancia() {
        if (instancia == null) {
            instancia = new BaseDatosUtil();
        }
        return instancia;
    }

    public void abrirConexion() throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/gestionPracticas?useTimezone=true&serverTimezone=Europe/Madrid";
        String user = "root";
        String password = "root";
        System.out.println("Entramos a conectar con la BBDD");
        if (conexion != null) {
            System.out.println("Ya hay una conexion");
        } else {
            System.out.println("Creamos una nueva conexion");
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Finalizamos config db");
        }
    }

    public void cerrarConexion() throws SQLException {
        conexion.close();
    }

    public void cambiarContrasena(Persona persona, String contrasena) throws Exception {
        if (persona == null) {
            throw new Exception("La persona no existe");
        }

        persona.setContrasena(contrasena);
        String consulta = "update Persona set contrasena = ? where usuario = ?";
        ps = conexion.prepareStatement(consulta);
        ps.setString(1, persona.getContrasena());
        ps.setString(2, persona.getUsuario());
        ps.executeUpdate();

        ps.close();
    }

    public void hashearContrasenas() throws NoSuchAlgorithmException, InvalidKeySpecException, Exception { //hashea la contraseña de todos los usuarios almacenados en la bbdd. No hashear contraseñas que ya esten hasheadas o se pierde la contraseña original.
        ArrayList<Persona> users;
        users = getAllUsers();

        String passwordHashed;
        for (int i = 0; i < users.size(); i++) {
            Persona user = users.get(i);
            passwordHashed = utiles.HashPasswordUtil.generarPasswordHash(user.getContrasena());
            cambiarContrasena(user, passwordHashed);
        }
    }

    public java.util.ArrayList<modelos.Persona> getAllUsers() throws SQLException {
        ArrayList<modelos.Persona> users = new java.util.ArrayList();
        String nif;
        String usuario;
        String contrasena;

        statement = conexion.createStatement();
        rs = statement.executeQuery("SELECT * FROM Persona");
        while (rs.next()) {
            nif = rs.getString("nif");
            usuario = rs.getString("usuario");
            contrasena = rs.getString("contrasena");
            users.add(new modelos.Persona(nif, usuario, contrasena));
        }
        rs.close();
        statement.close();
        return users ;
    }
}