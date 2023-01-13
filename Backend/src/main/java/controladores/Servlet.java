package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utiles.BaseDatosUtil;

public class Servlet extends HttpServlet {

    static final float IVA = (float) 1.21;
    public static Logger logBBDD;
    public static Logger log;
    private BaseDatosUtil bd;

    @Override
    public void init(ServletConfig cfg) throws ServletException {
        bd = BaseDatosUtil.getInstancia();
        
        try {
            bd.abrirConexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            logBBDD = Logger.getLogger("logger");
            logBBDD.addHandler(new FileHandler("logBBDD.xml"));
            log = Logger.getLogger("logger");
            log.addHandler(new FileHandler("logApp.xml"));
            Servlet.logBBDD.log(Level.INFO ,"WEB INICIADA------------------------------------");
        }catch(Exception e){
        }
    }

    @Override
    public void service(HttpServletRequest req,
            HttpServletResponse res) throws ServletException, IOException {
        HttpSession s = req.getSession(true);
        // llamar a inicio
    }

    
    private void inicio(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
        HttpSession s = req.getSession(true);
        String nombreUsuario = (String) req.getParameter("usuario");
        String password = (String) req.getParameter("password");
        s.setAttribute("usuario", nombreUsuario);
        if (bd.login(nombreUsuario, password)) {
            if (bd.isAlumno(nombreUsuario)) {
                //alumno
            } else if (bd.isTutor(nombreUsuario)){
                //tutor
            } else if (bd.isResponsable(nombreUsuario)){
                //reponsable
            }
        } else {
            //usuario no valido
        }
    }

    @Override
    public void destroy() {
        try {
            bd.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.destroy();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
