/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Vehiculo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Volksjagger
 */
@WebServlet(name = "ControlVehiculo", urlPatterns = {"/ControlVehiculo"})
public class ControlVehiculo extends HttpServlet {
    Vehiculo objVehiculo = new Vehiculo(); 
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
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String accion = request.getParameter("btnAccion"); 
            
            if(accion.equals("Ingresar")){
                
                //Generar un codigo al azar para cada ingreso?
                String placaVehiculo = request.getParameter("placaVehiculo"); 
                String tipoVehiculo = request.getParameter("tipoVehiculo");
                // Funcion para capturar el tiempo de ingreso 
                
                objVehiculo.setPlacaVehiculo(placaVehiculo);
                objVehiculo.setTipoVehiculo(tipoVehiculo);
                //objVehiculo.setTiempoIngreso(tiempoIngreso);
                
                
                objVehiculo.ingresarVehiculo();
                
                String mensaje = "<html> <body>"+
                                 " <script type='text/javaScript'> "+
                                 "      alert('Ingreso del vehiculo registrado'); "+
                                 "      window.location.href='index.jsp'"+
                                 "</script> </body> </html>"; 
                
                out.println(mensaje);
            }
                        
            else if (accion.equals("Salir")){
                
                String placaVehiculo = request.getParameter("placaVehiculo"); 
                
                objVehiculo.setPlacaVehiculo(placaVehiculo);
                
                String respuesta = objVehiculo.salirVehiculo();
                
                if (respuesta == null){
                    String mensaje = "<html> <body>"+
                                 " <script type='text/javaScript'> "+
                                 "      alert('El vehiculo ha salido del parqueadero'); "+
                                 "      window.location.href='index.jsp'"+
                                 "</script> </body> </html>"; 
                
                    out.println(mensaje);
                }
                else {
                    String mensaje = "<html> <body>"+
                                 " <script type='text/javaScript'> "+
                                 "      alert('Error en la salida'); "+
                                 "      window.location.href='index.jsp'"+
                                 "</script> </body> </html>"; 
                
                    out.println(mensaje);
                }
                
            }
           
        }
        catch(Exception error){
            System.out.println("Error Controlador: "+ error);
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
