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
import modelo.Usuarios;


public class sr_usuarios extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Usuarios usuario;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sr_usuarios</title>");            
            out.println("</head>");
            out.println("<body>");
            if("Modificar".equals(request.getParameter("btn_modificar"))){
                 usuario = new Usuarios (Integer.valueOf(request.getParameter("txt_id")),request.getParameter("txt_nombre"),Integer.valueOf(request.getParameter("drop_productos")),Integer.valueOf(request.getParameter("drop_marcas")),Integer.valueOf(request.getParameter("drop_empleados")),Integer.valueOf(request.getParameter("drop_puestos")),Integer.valueOf(request.getParameter("drop_clientes")),Integer.valueOf(request.getParameter("drop_proveedores")),Integer.valueOf(request.getParameter("drop_ventas")),Integer.valueOf(request.getParameter("drop_compras")),Integer.valueOf(request.getParameter("drop_usuarios")));
          if(usuario.modificar()>0){  
              response.sendRedirect("usuarios.jsp");
          }else{
              
              response.sendRedirect("usuarios.jsp");
              //out.println("<a href ='usuarios.jsp'>regresar</a>");       
           } 
                   
            }
            out.println("<h1>Servlet sr_usuarios at " + request.getContextPath() + "</h1>");
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
