package controladores;

import utiles.BaseDatosUtil;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import modelos.OfertaPracticas;
import modelos.Persona;

public class NewMain {
    public static Logger logBBDD;
    public static Logger log;
    public static void main(String[] args) throws NoSuchAlgorithmException, Exception {
        try {
            logBBDD = Logger.getLogger("logger");
            logBBDD.addHandler(new FileHandler("logBBDD.xml"));
            log = Logger.getLogger("logger");
            log.addHandler(new FileHandler("logApp.xml"));
            NewMain.logBBDD.log(Level.INFO ,"WEB INICIADA------------------------------------", new Date() );
        }catch(Exception e){
            
        }
        
        /*
        ArrayList<Persona> users;
        users = bd.getAllUsers();
        for (int i=0; i<users.size(); i++){
            Persona user = users.get(i);
            System.out.println(user.getUsuario());
            System.out.println(user.getContrasena());
            System.out.println(utiles.HashPasswordUtil.validarPassword("admin", user.getContrasena()));
            System.out.println("------------------------------");
        }
        */
        
        //System.out.println(bd.getUser("alba.ramos").getNif());
        //System.out.println(bd.isAlumno("alejandro.mendez"));
        //System.out.println(bd.registrarEmpresa("prueba", "prueba", "prueba"));
        //System.out.println(bd.registrarTutor("aaaaaa", "aaaaaa", "aaaaaa", "A54357254", "aaaaaa"));
        //System.out.println(bd.registrarOferta("2022/2023", "", 35, Date.valueOf("2023-02-01"), new Time(1567315800000L), new Time(1567315800000L), "espanol C2, ingles B2", 2, "Participacion en torneos CTF y experiencia en pentesting en paginas como HacktheBox", 1200, "Pentesting auditoria", "A58818501", "alba.ramos"));
        /*
        ArrayList<OfertaPracticas> ofertasPracticas = bd.getAllOfertasPracticas();
        for (int i=0; i<ofertasPracticas.size(); i++) {
            System.out.println(ofertasPracticas.get(i).toString());
        }
        */
        
        bd.cerrarConexion();
    }

}
