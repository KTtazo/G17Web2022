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

/**
 * Define objetos y metodos necesarios para crear una conexion e interactuar con una base de datos mysql
 * @author Daniel Pastor Miguel
 */

public class BaseDatosUtil {

    private Connection conexion;
    private Statement statement;
    private PreparedStatement ps;
    private ResultSet rs;

    /**
     * Atributo que referencia una base de datos para la implementacion del patron singleton
     */
    private static BaseDatosUtil instancia;

    private BaseDatosUtil() {
    }

    public static BaseDatosUtil getInstancia() {
        if (instancia == null) {
            instancia = new BaseDatosUtil();
        }
        return instancia;
    }

    /**
     * Abre una conexion con una base de datos mysql en localhost:3306 y credenciales root:root
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
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

    /**
     * Cierra una conexion
     * @throws SQLException 
     */
    public void cerrarConexion() throws SQLException {
        conexion.close();
    }

    /**
     * Cambia la contrasena de un objeto tipo Persona en una base de datos
     * @param persona
     * @param contrasena
     * @throws Exception 
     */
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

    /**
     * Hashea todas las contraseñas de una base de datos
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws Exception 
     */
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
    
    public Persona getUser(String nombre) throws SQLException{
        Persona user = new Persona();
        String consulta = "select * from Persona where usuario = ?";
        ps = conexion.prepareStatement(consulta);
        ps.setString(1, nombre);
        rs = ps.executeQuery();
        while (rs.next()) user = new Persona(rs.getString("nif"), rs.getString("usuario"), rs.getString("contrasena"));
        rs.close();
        ps.close();
        return user;
    }
    
    public boolean login(String nombreUsuario, String contrasena) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException{
        Persona usuario = getUser(nombreUsuario);
        return HashPasswordUtil.validarPassword(contrasena, usuario.getContrasena());
    }
    
    public boolean isAlumno(String nombreUsuario) throws SQLException{
        String consulta = "select * from Alumno where persona_usuario = ?";
        ps = conexion.prepareStatement(consulta);
        ps.setString(1, nombreUsuario);
        rs = ps.executeQuery();
        if (rs.next()) return true;
        rs.close();
        ps.close();
        return false;
    }
    
    public boolean isTutor(String nombreUsuario) throws SQLException{
        String consulta = "select * from Tutor where persona_usuario = ?";
        ps = conexion.prepareStatement(consulta);
        ps.setString(1, nombreUsuario);
        rs = ps.executeQuery();
        if (rs.next()) return true;
        rs.close();
        ps.close();
        return false;
    }
    
    public boolean isResponsable(String nombreUsuario) throws SQLException{
        String consulta = "select * from Responsable where persona_usuario = ?";
        ps = conexion.prepareStatement(consulta);
        ps.setString(1, nombreUsuario);
        rs = ps.executeQuery();
        if (rs.next()) return true;
        rs.close();
        ps.close();
        return false;
    }

    /**
     * Devuelve todos los objetos tipo Persona de una base de datos
     * @return
     * @throws SQLException 
     */
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