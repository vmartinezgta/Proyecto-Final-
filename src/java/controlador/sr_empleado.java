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
import modelo.Empleado;




public class sr_empleado extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Empleado empleado;
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
            
            if ("agregar".equals(request.getParameter("btn_agregar"))){
            empleado = new Empleado(0,Integer.valueOf(request.getParameter("drop_puesto")),request.getParameter("txt_DPI") ,request.getParameter("txt_nombres"),request.getParameter("txt_apellidos"),request.getParameter("txt_direccion"),request.getParameter("txt_telefono"),request.getParameter("txt_fn"),request.getParameter("txt_fil"),request.getParameter("fecha_factura"),Integer.valueOf(request.getParameter("gender")));
            out.println("<p>"+ request.getParameter("gender")+"</p>");
            if(empleado.agregar() > 0){
                    response.sendRedirect("empleados.jsp");
                 //  out.println("<h1>Ingreso Exitoso....................</h1>");
                   // out.println("<a href ='index.jsp'>Regresar</a>");
                }else{
                    out.println("<h1>Error....................</h1>");
                    out.println("<a href ='empleados.jsp'>Regresar</a>");
                }
            }
            
             if("modificar".equals(request.getParameter("btn_modificar"))){
                empleado = new Empleado(Integer.valueOf(request.getParameter("txt_id")),Integer.valueOf(request.getParameter("drop_puesto")),request.getParameter("txt_DPI") ,request.getParameter("txt_nombres"),request.getParameter("txt_apellidos"),request.getParameter("txt_direccion"),request.getParameter("txt_telefono"),request.getParameter("txt_fn"),request.getParameter("txt_fil"),request.getParameter("fecha_factura"),Integer.valueOf(request.getParameter("gender")));
                if(empleado.modificar() > 0){
                    response.sendRedirect("empleados.jsp");
                 /* out.println("<h1>Ingreso Exitoso....................</h1>");
                    out.println("<a href ='index.jsp'>Regresar</a>");*/
                }else{
                    out.println("<h1>Error....................</h1>");
                    out.println("<a href ='empleados.jsp'>Regresar</a>");
                }
            }
             
             if("eliminar".equals(request.getParameter("btn_eliminar"))){
                empleado = new Empleado(Integer.valueOf(request.getParameter("txt_id")),Integer.valueOf(request.getParameter("drop_puesto")),request.getParameter("txt_DPI"),request.getParameter("txt_nombres"),request.getParameter("txt_apellidos"),request.getParameter("txt_direccion"),request.getParameter("txt_telefono"),request.getParameter("txt_fn"),request.getParameter("txt_fil"),request.getParameter("fecha_factura"),Integer.valueOf(request.getParameter("gender")));
                if(empleado.eliminar() > 0){
                    response.sendRedirect("empleados.jsp");
                 //  out.println("<h1>Ingreso Exitoso....................</h1>");
                   // out.println("<a href ='index.jsp'>Regresar</a>");
                }else{
                    out.println("<h1>Error....................</h1>");
                    out.println("<a href ='empleados.jsp'>Regresar</a>");
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
