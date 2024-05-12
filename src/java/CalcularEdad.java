/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author crist
 */
@WebServlet(urlPatterns = {"/CalcularEdad"})
public class CalcularEdad extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Obtener la fecha de nacimiento del parámetro
            String fechaNacimientoStr = request.getParameter("fechanacimiento");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaNacimiento = null;
            try {
                fechaNacimiento = sdf.parse(fechaNacimientoStr);
            } catch (ParseException ex) {
                out.println("<h1>Error al analizar la fecha de nacimiento</h1>");
                return;
            }
            
            // Calcular la edad
            Date fechaActual = new Date();
            long diferenciaEnMilisegundos = fechaActual.getTime() - fechaNacimiento.getTime();
            long edadEnMilisegundos = diferenciaEnMilisegundos / (1000L * 60 * 60 * 24 * 365);
            int edad = (int) edadEnMilisegundos;
            
            // Mostrar la información en pantalla
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Edad Calculada</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Edad Calculada</h1>");
            out.println("<p>Edad = " + edad + "</p>");
            out.println("<p>Servlet que calcula la edad, pasando como parámetro la fecha de nacimiento (fechanacimiento = dd/MM/yyyy)</p>");
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
        try {
            // Marca de error: Llamada al método processRequest en el método doGet
            // Deberías manejar las solicitudes GET directamente o redirigirlas a otro lugar según tu lógica de negocio
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CalcularEdad.class.getName()).log(Level.SEVERE, null, ex);
        }
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try {
            // Marca de error: Llamada al método processRequest en el método doPost
            // Deberías manejar las solicitudes POST directamente o redirigirlas a otro lugar según tu lógica de negocio
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CalcularEdad.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

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
