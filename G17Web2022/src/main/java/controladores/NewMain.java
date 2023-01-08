package controladores;

import utiles.BaseDatosUtil;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import modelos.Persona;

public class NewMain {

    public static void main(String[] args) throws NoSuchAlgorithmException, Exception {
        
        BaseDatosUtil bd = BaseDatosUtil.getInstancia();
        bd.abrirConexion();
        
        //bd.hashearContrasenas();
        
        ArrayList<Persona> users;
        users = bd.getAllUsers();
        for (int i=0; i<users.size(); i++){
            Persona user = users.get(i);
            System.out.println(user.getUsuario());
            System.out.println(user.getContrasena());
            System.out.println(utiles.HashPasswordUtil.validarPassword("admin", user.getContrasena()));
            System.out.println("------------------------------");
        }
        
        bd.cerrarConexion();
    }

}
