/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Proveedores;


public class sr_provedores extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     Proveedores proveedor;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sr_empleado</title>");            
            out.println("</head>");
            out.println("<body>");
            if("Agregar".equals(request.getParameter("btn_agregar"))){
                proveedor = new Proveedores (Integer.valueOf(request.getParameter("txt_idproveedor")),request.getParameter("txt_proveedor"),request.getParameter("txt_nit"),request.getParameter("txt_direccion"),request.getParameter("txt_telefono"));
                if(proveedor.agregar() > 0){
                    response.sendRedirect("proveedores.jsp");
                 //  out.println("<h1>Ingreso Exitoso....................</h1>");
                   // out.println("<a href ='index.jsp'>Regresar</a>");
                }else{
                    out.println("<h1>Error....................</h1>");
                    out.println("<a href ='proveedores.jsp'>Regresar</a>");
                }
            }
            
             if("Modificar".equals(request.getParameter("btn_modificar"))){
                proveedor = new Proveedores (Integer.valueOf(request.getParameter("txt_idproveedor")),request.getParameter("txt_proveedor"),request.getParameter("txt_nit"),request.getParameter("txt_direccion"),request.getParameter("txt_telefono"));
                if(proveedor.modificar() > 0){
                    response.sendRedirect("proveedores.jsp");
                 /* out.println("<h1>Ingreso Exitoso....................</h1>");
                    out.println("<a href ='index.jsp'>Regresar</a>");*/
                }else{
                    out.println("<h1>Error....................</h1>");
                    out.println("<a href ='proveedores.jsp'>Regresar</a>");
                }
            }
             
             if("Eliminar".equals(request.getParameter("btn_eliminar"))){
                proveedor = new Proveedores (Integer.valueOf(request.getParameter("txt_idproveedor")),request.getParameter("txt_proveedor"),request.getParameter("txt_nit"),request.getParameter("txt_direccion"),request.getParameter("txt_telefono"));
                if(proveedor.eliminar() > 0){
                    response.sendRedirect("proveedores.jsp");
                 //  out.println("<h1>Ingreso Exitoso....................</h1>");
                   // out.println("<a href ='index.jsp'>Regresar</a>");
                }else{
                    out.println("<h1>Error....................</h1>");
                    out.println("<a href ='proveedores.jsp'>Regresar</a>");
                }
            }
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
