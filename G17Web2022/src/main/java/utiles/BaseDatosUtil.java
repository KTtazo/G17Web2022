package utiles;

import controladores.NewMain;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
import java.util.List;
import java.util.logging.Level;
import modelos.InformePracticas;
import modelos.OfertaPracticas;
import modelos.OfertaPracticas_has_Alumno;
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
             NewMain.logBBDD.log(Level.INFO ,"Conexion con BBDD establecida" );
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
            NewMain.logBBDD.log(Level.WARNING ,"El usuario "+persona.getUsuario()+" no existe" );
            NewMain.log.log(Level.WARNING ,"Error al cambiar la contrasena del usuario"+ persona.getUsuario() );
            throw new Exception("La persona no existe");
       
        }
        persona.setContrasena(HashPasswordUtil.generarPasswordHash(contrasena));
        String consulta = "update Persona set contrasena = ? where usuario = ?";
        ps = conexion.prepareStatement(consulta);
        ps.setString(1, persona.getContrasena());
        ps.setString(2, persona.getUsuario());
        ps.executeUpdate();
       NewMain.logBBDD.log(Level.INFO ,"Contrasena de usuario "+persona.getUsuario()+" cambiada" );
       NewMain.log.log(Level.INFO ,"Contrasena de usuario "+ persona.getUsuario()+ " cambiada" );
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
        NewMain.logBBDD.log(Level.INFO ,"Consulta si el usuario "+nombre +" existe" );
        rs.close();
        ps.close();
        return user;
        
    }

    public boolean login(String nombreUsuario, String contrasena) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
        Persona usuario = getUser(nombreUsuario);
        NewMain.logBBDD.log(Level.INFO ,"Consulta si el usuario "+nombreUsuario +" y su contrsena coinciden" );
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
            NewMain.log.log(Level.INFO ,"Sesión iniciada como ALUMNO " );
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
            NewMain.log.log(Level.INFO ,"Sesión iniciada como TUTOR " );
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
            NewMain.log.log(Level.INFO ,"Sesión iniciada como RESPONSABLE " );
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
        NewMain.logBBDD.log(Level.INFO ,"Registra empresa con nombre "+nombre +" insertada" );
        ps.close();
        NewMain.log.log(Level.INFO ,"Nueva empresa con nombre "+nombre+" registrada" );
 
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
            NewMain.log.log(Level.INFO ,"Tutor con nombre "+nombreUsuario+" registrado" );
        } catch (SQLIntegrityConstraintViolationException ex) { //si no se puede insertar el tutor porque la empresa no existe, hay que borrar la entrada de persona que se ha añadido antes
            consulta = "DELETE FROM Persona where usuario = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, nombreUsuario);
            ps.executeUpdate();
            ps.close();
            NewMain.logBBDD.log(Level.WARNING ,"Error al registrar tutor" );
            return false;
        }
        NewMain.logBBDD.log(Level.INFO ,"Registra tutor con nombre "+nombreUsuario +" insertada" );
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
            NewMain.logBBDD.log(Level.WARNING ,"Error al registrar oferta" );
            return false;
            
        }
        NewMain.logBBDD.log(Level.INFO ,"Nueva oferta de practicas creada" );
            NewMain.log.log(Level.INFO ,"Nueva oferta creada" );
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
        NewMain.logBBDD.log(Level.INFO ,"Muestra todas las ofertas de practicas" );
        NewMain.log.log(Level.INFO ,"Mostrando todas las ofertas" );
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
        NewMain.logBBDD.log(Level.INFO ,"Muestra todos los usuarios" );
        rs.close();
        statement.close();
        return users;
    }
       ///COMPROBAR!!!!!!!!!!!!!!!!!!!!!!
    public boolean registrarSeleccion(String alumno_iniciado,int id_seleccionado,int prioridad_seleccionada) throws SQLException {
        String consulta = "INSERT INTO oferta_practicas_has_alumno (`OfertaPracticas_idOfertaPracticas`, `Alumno_Persona_Usuario`, `prioridad`) VALUES (?, ?, ?)";
        ps = conexion.prepareStatement(consulta);
        ps.setInt(1,id_seleccionado );
        ps.setString(2, alumno_iniciado);
        ps.setInt(3, prioridad_seleccionada);
        try {
            ps.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException ex) {
            ps.close();
            NewMain.logBBDD.log(Level.WARNING ,"Error al registrar seleccion" );
            return false;
        }
        NewMain.logBBDD.log(Level.INFO ,"Regista seleccion de "+alumno_iniciado +" a oferta con id "+ id_seleccionado);
        NewMain.log.log(Level.INFO ,"Seleccion de "+alumno_iniciado +" a oferta con id "+ id_seleccionado+ " registrada" );
        ps.close();
        return true;
    }
        ///COMPROBAR!!!!!!!!!!!!!!!!!!!!!!
    public ArrayList<OfertaPracticas_has_Alumno> getAllSelecciones() throws SQLException {
        ArrayList<OfertaPracticas_has_Alumno> ofertaPracticas_has_Alumno = new ArrayList();

        statement = conexion.createStatement();
        rs = statement.executeQuery("SELECT * FROM oferta_practicas_has_alumno ");
        while (rs.next()) {
            ofertaPracticas_has_Alumno.add(
                new OfertaPracticas_has_Alumno(
                    rs.getInt("OfertaPracticas_idOfertaPracticas"),
                    rs.getString("Alumno_Persona_Usuario"),
                    rs.getInt("prioridad")   
                )
            )      
            ;
        }
         NewMain.log.log(Level.INFO ,"Mostrando todos las selecciones de Ofertas de practicas");
        NewMain.logBBDD.log(Level.INFO ,"Muestra todos las selecciones de Ofertas de practicas");
        rs.close();
        statement.close();
        return ofertaPracticas_has_Alumno;
    }   
    public void asignarTodasPracticas() throws SQLException{
       statement = conexion.createStatement();
        rs = statement.executeQuery("SELECT * FROM oferta_practicas_has_alumno");
        while (rs.next()) {
            asignaPractica();
        }
        NewMain.log.log(Level.INFO ,"Practicas asignadas a los alumno");
        NewMain.logBBDD.log(Level.INFO ,"Practicas asignadas a los alumno");
        rs.close();
    }
    public void asignaPractica() throws SQLException{
        String nombreAlumno= alumnoMejorCalificado();
        int id_oferta= elegirPorPrioridad(alumnoMejorCalificado());
        if(existenPlazas() ){
          String consulta = "UPDATE Alumno SET oferta_practicas_id_oferta_practicas =? "
                + "         WHERE persona_usuario=?";
        ps = conexion.prepareStatement(consulta);
        ps.setInt(1, id_oferta);
        ps.setString(2, nombreAlumno);
        
        ps.executeUpdate();
        ps.close();  
        borrarOfertasByNombre(nombreAlumno);
        
        }
     
    }
    public void borrarOfertasByNombre(String nombre) throws SQLException{
        String consulta2= "DELETE FROM oferta_practicas_has_alumno "
                            + "WHERE alumno_persona_usuario= ?";
                    ps = conexion.prepareStatement(consulta2);
                      ps.setString(1, nombre);
                      ps.executeUpdate();
                      NewMain.logBBDD.log(Level.INFO ,"Usuario: "+nombre+ " eliminado de todas las selecciones");
                      ps.close();
     }
    public boolean existenPlazas() throws SQLException{
        int id_oferta= elegirPorPrioridad(alumnoMejorCalificado());
        int plazas;
        statement = conexion.createStatement();
        String consulta= ("SELECT plazas FROM oferta_practicas WHERE if_oferta_practicas=? ");
        ps = conexion.prepareStatement(consulta);
        ps.setInt(1, id_oferta);
        rs = ps.executeQuery();
        plazas= rs.getInt(1);
        rs.close();
        ps.close();
                if(plazas>1){
                    String consulta2= "UPDATE oferta_practicas SET plazas=plazas-1"
                            + "WHERE id_oferta_practicas= ?";
                      ps = conexion.prepareStatement(consulta2);
                      ps.setInt(1, id_oferta);
                      ps.executeUpdate();
                      ps.close();
                      return true;
                }else if(plazas==1){                
                      String consulta2= "DELETE FROM oferta_practicas "
                            + "WHERE id_oferta_practicas= ?";
                      ps = conexion.prepareStatement(consulta2);
                      ps.setInt(1, id_oferta);
                      ps.executeUpdate();
                      ps.close();
                      return true;
                }else{
                    String consulta2= "DELETE FROM oferta_practicas "
                            + "WHERE id_oferta_practicas= ?";
                    ps = conexion.prepareStatement(consulta2);
                      ps.setInt(1, id_oferta);
                      ps.executeUpdate();
                      NewMain.logBBDD.log(Level.WARNING ,"Oferta: "+id_oferta+" con menos de 1 plaza");
                      NewMain.log.log(Level.WARNING ,"Oferta: "+id_oferta+" con menos de 1 plaza");
                      ps.close();
                    return false;
                }
        
    }
    
    public String alumnoMejorCalificado() throws SQLException{
         
        statement = conexion.createStatement();
        rs = statement.executeQuery("SELECT persona_usuario "
                                        +"FROM Alumno "
                                        +"WHERE nota_media= (SELECT MAX(nota_media) FROM Alumno"
                + "                     INNER JOIN Oferta_Practicas_has_Alumno"
                + "                     ON persona_usuario= alumno_persona_usuario )");
            String mejorAlumno = rs.getString(1);
            return mejorAlumno;
        
    }
    public int elegirPorPrioridad(String nombreAlumno) throws SQLException{
        nombreAlumno= alumnoMejorCalificado();
        String consulta = "select oferta_practicas_id_oferta_practicas" +
                            "FROM oferta_practicas_has_alumno" +
                            "WHERE alumno_persona_usuario=?"+
                            "ORDER BY prioridad DESC" ;
        ps = conexion.prepareStatement(consulta);
        ps.setString(1, nombreAlumno);
        statement = conexion.createStatement();
        rs = ps.executeQuery();
        int ofertaSeleccionada = rs.getInt(1);
        return ofertaSeleccionada;
    }
    public int NumeroTotalAlumnos() throws SQLException{
      
        statement = conexion.createStatement();
        rs = statement.executeQuery("SELECT count(*)"
                                        +"FROM Alumno ");
            int total = rs.getInt(1);
            NewMain.logBBDD.log(Level.INFO ,"Muestra numero total de alumnos");
            NewMain.log.log(Level.WARNING ,"Mostrando numero total de alumnos");
           return total;
             
    }
    public List NumeroTotalAlumnosPorEmpresa() throws SQLException{
      List<Object> empresaRecuento = new ArrayList<Object>();
        statement = conexion.createStatement();
        rs = statement.executeQuery("SELECT Empresa.nombre, COUNT(*) " +
                            "FROM Alumno " +
                            "INNER JOIN oferta_practicas " +
                            "on Alumno.oferta_practicas_id_oferta_practicas= oferta_practicas.id_oferta_practicas " +
                            "INNER JOIN Empresa " +
                            "on oferta_practicas.tutor_Empresa_cif= Empresa.cif " +
                            "GROUP BY Empresa.nombre");
        NewMain.logBBDD.log(Level.INFO ,"Muestra numero total de alumnos por empresa");           
         NewMain.log.log(Level.WARNING ,"Mostrando numero total de alumnos por empresa");
               return empresaRecuento;
      
           
    }
   public boolean registrarInforme(String comentarios,double nota,String Tutor_Persona_usuario ,String Tutor_Empresa_cif,String Alumno_Persona_usuario ) throws SQLException {
        String consulta = "INSERT INTO InformePracticas (`comentarios`, `nota`, `Tutor_Persona_usuario`, `Tutor_Empresa_cif`, `Alumno_Persona_usuario` ) "
                + " VALUES (?, ?, ? , ? , ? )";
        ps = conexion.prepareStatement(consulta);
        ps.setString(2, comentarios);
        ps.setDouble(1,nota );
        ps.setString(2, Tutor_Persona_usuario);
        ps.setString(2, Tutor_Empresa_cif);
        ps.setString(2, Alumno_Persona_usuario);
        try {
            ps.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException ex) {
            ps.close();
            return false;
        }
        ps.close();
        NewMain.logBBDD.log(Level.INFO ,"Informe de alumno: "+ Alumno_Persona_usuario+" creado" );
       NewMain.logBBDD.log(Level.INFO ,"Informe general descargado" );
        return true;
        
    }
   
    public void generaInformeGlobal() throws FileNotFoundException, SQLException, IOException{
        ArrayList<InformePracticas> informe = new ArrayList();
        File csvFile = new File("InformeGeneral.csv");
        PrintWriter out = new PrintWriter(csvFile);
        statement = conexion.createStatement();
        rs = statement.executeQuery("SELECT * FROM InformePracticas");
        while (rs.next()) {
            informe.add(
                new InformePracticas(
                    rs.getString("COMENTARIOS"),
                    rs.getDouble("NOTA"),
                    rs.getString("TUTOR"),
                    rs.getString("CIF DE LA EMPRESA"),
                    rs.getString("USUARIO")
                    )
            );
        }
        for(InformePracticas informePracticas: informe){
            out.printf(informePracticas.getAlumno_Persona_usuario(), 
                    informePracticas.getComentarios(),
                    informePracticas.getNota(),
                    informePracticas.getTutor_Empresa_cif(),
                    informePracticas.getTutor_Persona_usuario());
        }
         NewMain.logBBDD.log(Level.INFO ,"Acceso a todos los informes" );
          NewMain.logBBDD.log(Level.INFO ,"Informe general descargado" );
        out.close();
        rs.close();
        statement.close();
    }    
}
