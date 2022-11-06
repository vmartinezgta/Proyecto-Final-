/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;


public class Empleado {
    private int id,idPuesto,genero;
    private String dpi,nombres, apellidos, direccion, telefono, fecha_nacimiento, fecha_inicio_labores,fechaingreso;
   private Conexioon cn;
    public Empleado (){}

    public Empleado(int id, int idPuesto, String dpi, String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento, String fecha_inicio_labores, String fechaingreso, int genero) {
        this.id = id;
        this.idPuesto = idPuesto;
        this.dpi = dpi;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_inicio_labores = fecha_inicio_labores;
        this.fechaingreso = fechaingreso;
        this.genero = genero;
    }

   
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

   

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getFecha_inicio_labores() {
        return fecha_inicio_labores;
    }

    public void setFecha_inicio_labores(String fecha_inicio_labores) {
        this.fecha_inicio_labores = fecha_inicio_labores;
    }

    public String getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(String fechaingreso) {
        this.fechaingreso = fechaingreso;
    }
    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }
    
    public DefaultTableModel leer(){
   DefaultTableModel tabla = new DefaultTableModel();
   try{
       cn = new Conexioon();
       cn.abrir_conexion();
       String query = "SELECT e.idEmpleado as id,e.nombres,e.apellidos,e.dirreccion,e.telefono,e.DPI,e.genero,e.fecha_nacimiento,e.fecha_inicio_labores,e.fechaingreso,p.puesto,p.idPuesto FROM empleados as e inner join puestos as p on e.idPuesto = p.idPuesto;";
       ResultSet consulta = cn.conexioonbd.createStatement().executeQuery(query);
       String encabezado[] = {"id", "nombres", "apellidos","dirreccion","telefono","DPI","genero","fecha_nacimiento","fecha_inicio_labores","fechaingreso","puesto","idPuesto"};
       tabla.setColumnIdentifiers(encabezado);
       String datos[] = new  String[12];
       while(consulta.next()){
           datos[0] = consulta.getString("id");
           datos[1] = consulta.getString("nombres");
           datos[2] = consulta.getString("apellidos");
           datos[3] = consulta.getString("dirreccion");
           datos[4] = consulta.getString("telefono");
           datos[5] = consulta.getString("DPI");
           datos[6] = consulta.getString("genero");
           datos[7] = consulta.getString("fecha_nacimiento");
           datos[8] = consulta.getString("fecha_inicio_labores");
           datos[9] = consulta.getString("fechaingreso");
           datos[10] = consulta.getString("puesto");
           datos[11] = consulta.getString("idPuesto");
           tabla.addRow(datos);
       }
       
       cn.cerrar_conexion();
   }catch(SQLException ex){
       System.out.println(ex.getMessage());
   }
   return tabla;
   }
  
   
    public int agregar(){
        int retorno = 0;
    try{
        PreparedStatement parametro;
     
        cn = new Conexioon();
        String query="INSERT INTO empleados(nombres,apellidos,dirreccion,telefono,DPI,genero,fecha_nacimiento,idPuesto,fecha_inicio_labores,fechaingreso)VALUES(?,?,?,?,?,?,?,?,?,?);";
        cn.abrir_conexion();
        parametro = (PreparedStatement)cn.conexioonbd.prepareStatement(query);
        parametro.setString(1, getNombres());
        parametro.setString(2, getApellidos());
        parametro.setString(3, getDireccion());
        parametro.setString(4, getTelefono());
        parametro.setString(5, getDpi());
        parametro.setInt(6, getGenero());
        parametro.setString(7, getFecha_nacimiento());
        parametro.setInt(8, getIdPuesto());
        parametro.setString(9, getFecha_inicio_labores());
        parametro.setString(10, getFechaingreso());
        retorno =parametro.executeUpdate();
        cn.cerrar_conexion();
        
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
        retorno = 0;
    }
    
    return retorno;
    }
  
    public int modificar(){
        int retorno = 0;
        try{
            PreparedStatement parametro;
            cn = new Conexioon();
            String query = "update empleados set nombres=?, apellidos=?, dirreccion=?, telefono=?, DPI=?, genero=?, fecha_nacimiento=?, idPuesto=?,fecha_inicio_labores=?,fechaingreso=? where idEmpleado=?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexioonbd.prepareStatement(query);
            parametro.setString(1, this.getNombres());
            parametro.setString(2, this.getApellidos());
            parametro.setString(3, this.getDireccion());
            parametro.setString(4, this.getTelefono());
            parametro.setString(5, this.getDpi());
            parametro.setInt(6, this.getGenero());
            parametro.setString(7, this.getFecha_nacimiento());
            parametro.setInt(8, this.getIdPuesto());
            parametro.setString(9, this.getFecha_inicio_labores());
            parametro.setString(10, this.getFechaingreso());
            parametro.setInt(11, this.getId());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage()); 
        }
        return retorno;  
    }
    

    public int eliminar(){
        int retorno = 0;
        try{
            PreparedStatement parametro;
            cn = new Conexioon();
            String query = "delete from empleados where idEmpleado=?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexioonbd.prepareStatement(query);
            parametro.setInt(1, this.getId());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage()); 
        }
        return retorno;  
    }
    
    public  HashMap ListaEmpleados(){
 HashMap <String,String> drop = new  HashMap();
 
try{
        String query ="Select idEmpleado as id,nombres from empleados";
         cn = new Conexioon();
         cn.abrir_conexion();
            ResultSet consulta = cn.conexioonbd.createStatement().executeQuery(query);
            while (consulta.next()){
            drop.put(consulta.getString("id"),consulta.getString("nombres"));
            }   
         cn.cerrar_conexion();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
 
 return drop;
}

}
