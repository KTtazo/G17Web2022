package utiles;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import modelos.OfertaPracticas;
import modelos.Persona;

/**
 * Define objetos y metodos necesarios para crear una conexion e interactuar con una base de datos mysql
 *
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
     *
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
     *
     * @throws SQLException
     */
    public void cerrarConexion() throws SQLException {
        conexion.close();
    }

    /**
     * Cambia la contrasena de un objeto tipo Persona en una base de datos
     *
     * @param persona
     * @param contrasena
     * @throws Exception
     */
    public void cambiarContrasena(Persona persona, String contrasena) throws Exception {
        if (persona == null) {
            throw new Exception("La persona no existe");
        }
        persona.setContrasena(HashPasswordUtil.generarPasswordHash(contrasena));
        String consulta = "update Persona set contrasena = ? where usuario = ?";
        ps = conexion.prepareStatement(consulta);
        ps.setString(1, persona.getContrasena());
        ps.setString(2, persona.getUsuario());
        ps.executeUpdate();
        ps.close();
    }

    /**
     * Hashea todas las contraseñas de una base de datos
     *
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

    public Persona getUser(String nombre) throws SQLException {
        Persona user = new Persona();
        String consulta = "select * from Persona where usuario = ?";
        ps = conexion.prepareStatement(consulta);
        ps.setString(1, nombre);
        rs = ps.executeQuery();
        while (rs.next()) {
            user = new Persona(rs.getString("nif"), rs.getString("usuario"), rs.getString("contrasena"));
        }
        rs.close();
        ps.close();
        return user;
    }

    public boolean login(String nombreUsuario, String contrasena) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
        Persona usuario = getUser(nombreUsuario);
        return HashPasswordUtil.validarPassword(contrasena, usuario.getContrasena());
    }

    public boolean isAlumno(String nombreUsuario) throws SQLException {
        String consulta = "select * from Alumno where persona_usuario = ?";
        ps = conexion.prepareStatement(consulta);
        ps.setString(1, nombreUsuario);
        rs = ps.executeQuery();
        if (rs.next()) {
            rs.close();
            ps.close();
            return true;
        }
        rs.close();
        ps.close();
        return false;
    }

    public boolean isTutor(String nombreUsuario) throws SQLException {
        String consulta = "select * from Tutor where persona_usuario = ?";
        ps = conexion.prepareStatement(consulta);
        ps.setString(1, nombreUsuario);
        rs = ps.executeQuery();
        if (rs.next()) {
            ps.close();
            rs.close();
            return true;
        }
        rs.close();
        ps.close();
        return false;
    }

    public boolean isResponsable(String nombreUsuario) throws SQLException {
        String consulta = "select * from Responsable where persona_usuario = ?";
        ps = conexion.prepareStatement(consulta);
        ps.setString(1, nombreUsuario);
        rs = ps.executeQuery();
        if (rs.next()) {
            ps.close();
            rs.close();
            return true;
        }
        rs.close();
        ps.close();
        return false;
    }

    /**
     *
     * @param cif
     * @param nombre
     * @param sector
     * @return true si se ha insertado correctamente. False si ya existe una entrada en la base de datos con el mismo cif.
     * @throws SQLException
     */
    public boolean registrarEmpresa(String cif, String nombre, String sector) throws SQLException {
        String consulta = "INSERT INTO Empresa (`cif`, `nombre`, `sector`) VALUES (?, ?, ?)";
        ps = conexion.prepareStatement(consulta);
        ps.setString(1, cif);
        ps.setString(2, nombre);
        ps.setString(3, sector);
        try {
            ps.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException ex) {
            ps.close();
            return false;
        }
        ps.close();
        return true;
    }

    public boolean registrarTutor(String nombreUsuario, String contrasena, String nif, String empresaCif, String cargo) throws SQLException {
        String consulta = "INSERT INTO Persona (`usuario`, `contrasena`, `nif`) VALUES (?, ?, ?)";
        ps = conexion.prepareStatement(consulta);
        ps.setString(1, nombreUsuario);
        ps.setString(2, contrasena);
        ps.setString(3, nif);
        try {
            ps.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException ex) {
            ps.close();
            return false;
        }
        consulta = "INSERT INTO Tutor (`empresa_cif`, `persona_usuario`, `cargo`) VALUES (?, ?, ?)";
        ps = conexion.prepareStatement(consulta);
        ps.setString(1, empresaCif);
        ps.setString(2, nombreUsuario);
        ps.setString(3, cargo);
        try {
            ps.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException ex) { //si no se puede insertar el tutor porque la empresa no existe, hay que borrar la entrada de persona que se ha añadido antes
            consulta = "DELETE FROM Persona where usuario = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, nombreUsuario);
            ps.executeUpdate();
            ps.close();
            return false;
        }
        ps.close();
        return true;
    }

    public boolean registrarOferta(String curso, String descripcion, int duracion, Date fecha_inicio, Time hora_inicio, Time hora_salida, String idiomas, int plazas, String requisitos, int salario, String titulo, String tutor_empresa_cif, String tutor_persona_usuario) throws SQLException {
        String consulta = "INSERT INTO oferta_practicas (`id_oferta_practicas`, `curso`, `descripcion`, `duracion`, `fecha_inicio`, `hora_inicio`, `hora_salida`, `idiomas`, `plazas`, `requisitos`, `salario`, `titulo`, `tutor_empresa_cif`, `tutor_persona_usuario`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ps = conexion.prepareStatement(consulta);
        ps.setInt(1, 0);
        ps.setString(2, curso);
        ps.setString(3, descripcion);
        ps.setInt(4, duracion);
        ps.setDate(5, fecha_inicio);
        ps.setTime(6, hora_inicio);
        ps.setTime(7, hora_salida);
        ps.setString(8, idiomas);
        ps.setInt(9, plazas);
        ps.setString(10, requisitos);
        ps.setInt(11, salario);
        ps.setString(12, titulo);
        ps.setString(13, tutor_empresa_cif);
        ps.setString(14, tutor_persona_usuario);
        try {
            ps.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException ex) {
            ps.close();
            return false;
        }
        ps.close();
        return true;
    }

    public ArrayList<OfertaPracticas> getAllOfertasPracticas() throws SQLException {
        ArrayList<OfertaPracticas> ofertasPracticas = new ArrayList();

        statement = conexion.createStatement();
        rs = statement.executeQuery("SELECT * FROM oferta_practicas");
        while (rs.next()) {
            ofertasPracticas.add(
                new OfertaPracticas(
                    rs.getInt("id_oferta_practicas"),
                    rs.getString("descripcion"),
                    rs.getString("titulo"),
                    rs.getString("idiomas"),
                    rs.getString("requisitos"),
                    rs.getDate("fecha_inicio"),
                    rs.getString("curso"),
                    rs.getInt("duracion"),
                    rs.getTime("hora_inicio"),
                    rs.getTime("hora_salida"),
                    rs.getInt("plazas"),
                    rs.getInt("salario"),
                    rs.getString("tutor_persona_usuario"),
                    rs.getString("tutor_empresa_cif")     
                    )
            );
        }
        rs.close();
        statement.close();
        return ofertasPracticas;
    }

    /**
     * Devuelve todos los objetos tipo Persona de una base de datos
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<Persona> getAllUsers() throws SQLException {
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
        return users;
    }
}
