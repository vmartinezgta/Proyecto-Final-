
<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page import="modelo.Empleado"%>
<%@page import="modelo.Puesto"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="java.text.SimpleDateFormat"%>  
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleados</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="shortcut icon" href="imagen/icono.png" type="image/x-icon">
                 <link rel="stylesheet" href="estilo_formulario.css">

    </head>
    
    <body>
        
        <%
        HttpSession misession= (HttpSession) request.getSession();
        if(misession.getAttribute("inicio")=="iniciado"){
        HttpSession usuario= (HttpSession) request.getSession();
        String aux2 = (String)usuario.getAttribute("user2"); 
        Menu menu2 = new Menu();
        menu2.Pureba(aux2);
        if(menu2.getEmpleados()==1){
        %>
        
        <%@include file="header.jsp" %>
        
        <div class="container">
        <div class="modal fade" id="modal_empleado" role="dialog">
        <div class="modal-dialog">
        <div class="modal-content">
        <div class="modal-body">
           
        <form action="sr_empleado" method="post" class="form-group">
                
            <label for="lbl_id"><b>ID:</b></label>
            <input type="text" name="txt_id" id="txt_id" class="form-control" value ="0" readonly>  
            <br>
            <label for="lbl_nombres"><b>Nombres:</b></label>
            <input type="text" name="txt_nombres" id="txt_nombres" class="form-control" placeholder="Ejemplo:NOMBRE1 NOMBRE2" required>
            <br>   
            <label for="lbl_apellidos"><b>Apellidos:</b></label>
            <input type="text" name="txt_apellidos" id="txt_apellidos" class="form-control" placeholder="Ejemplo:APELLIDO1 APELLIDO2" required>  
            <br>    
            <label for="lbl_direccion"><b>Direccion:</b></label>
            <input type="text" name="txt_direccion" id="txt_direccion" class="form-control" placeholder="Ejemplo: # CASA CALLE ZONA CIUDAD" required>
            <br>    
            <label for="lbl_telefono"><b>Telefono:</b></label>
            <input type="number" name="txt_telefono" id="txt_telefono" class="form-control" placeholder="Ejemplo:55555555" required>  
            <br>    
            <label for="lbl_DPI"><b>DPI:</b></label>
            <input type="number" name="txt_DPI" id="txt_DPI" class="form-control" placeholder="Ejemplo:55555555" required> 
            <br>    
            <label><b>Género: </b></label> <br>
            <input type="radio" id="gender" name="gender" value="0" required>
            <label for="male">Hombre</label>
             <input type="radio" id="gender" name="gender" value="1" required>
            <label for="female">Mujer</label>
            <br>
            <label for="lbl_fn"><b>Fecha nacmiento:</b></label>
            <input type="date" name="txt_fn" id="txt_fn" class="form-control" required>
            <br>    
            <label for="lbl_puesto"><b>Puesto</b></label>
            <select name="drop_puesto" id="drop_list" class="form-control">
                 <% 
                    Puesto puesto = new Puesto();
                    HashMap<String, String> drop = puesto.drop_sangre();
                    for(String i: drop.keySet()){
                    out.println("<option value='" + i + "'>" + drop.get(i) +"</option>");
                    }
                %>
            </select>
            <br>    
            <label for="lbl_fil"><b>Fecha inicio de labores:</b></label>
            <input type="date" name="txt_fil" id="txt_fil" class="form-control" required>
            <br>    
           <label Style="color: black;"><b>Fecha de ingreso:</b></label>
               
                <%    
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
                Date date = new Date();  
               
                String fecha=  date.toString();
                out.println("<input class='form-control' type='text' name='fecha_factura' id='fecha_factura' value='"+fecha+"' readonly>");
                //System.out.println("<input type='date' name='fechaFactura' id='fechaFactura' value="+date+" class='form-control' readonly>");
                
                %>

            <br>
             
            <input type="submit" class="btn btn-warning" name="btn_agregar" id="btn_agregar" value="agregar" >
            <input type="submit" class="btn btn-warning" name="btn_modificar" id="btn_modificar" value="modificar">
            <input type="submit" class="btn btn-warning" name="btn_eliminar" id="btn_eliminar" value="eliminar"  onclick="javascript:if(!confirm('¿Desea Eliminar?'))return false">
            <button type="button" class="btn btn-warning" data-dismiss="modal">Cerrar</button>
               
            </form>
                
        </div>
        </div>
        </div>
        </div>  
        
        <div id="main-container-empleados">
        <table>
        <thead>
        <tr>
            <th>Nombres</th>
            <th>Apellidos</th>
            <th>Direccion</th>
            <th>Telefono</th>
            <th>DPI</th>
            <th>Nacimiento</th>
            <th>Fecha inicio de labores</th>
            <th>Fecha de ingreso</th>
            <th>Puesto</th>
      </tr>
    </thead>
    <tbody id="tbl_empleados">
        <% 
        Empleado empleado = new Empleado();
        DefaultTableModel tabla = new DefaultTableModel();
        tabla = empleado.leer();
        for (int t=0;t<tabla.getRowCount();t++){
            out.println("<tr data-id=" + tabla.getValueAt(t,0) + " data-id_p=" + tabla.getValueAt(t,11) + ">");
            out.println("<td>" + tabla.getValueAt(t,1) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,2) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,3) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,4) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,5) + "</td>");
          
            out.println("<td>" + tabla.getValueAt(t,7) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,8) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,9) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,10) + "</td>");
            out.println("</tr>");
        
        }
        %>
      
    </tbody>
    </table>
    <button type="button" name="btn_nuevo" id="btn_nuevo" data-toggle="modal" data-target="#modal_empleado" onclick="limpiar()">Formulario</button>

        </div>
    </div>
        
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    
    <script>  
        function limpiar(){
            $("#txt_id").val(0);
            $("#txt_nombres").val('');
            $("#txt_apellidos").val('');
            $("#txt_direccion").val('');
            $("#txt_telefono").val('');
            $("#txt_DPI").val('');
            $("#txt_fn").val('');
            $("#drop_list").val(1);
            $("#txt_fil").val('');
            $("#fi").val('');

        }

            

        $('#tbl_empleados').on('click','tr td', function(evt){
        var target,id,id_p,nombres,apellidos,direccion,telefono,dpi,nacimiento,labores,ingreso,genero;

        target = $(event.target);
        id = target.parent().data('id');
        id_p = target.parent().data('id_p');
        nombres= target.parents("tr").find("td").eq(0).html();
        apellidos= target.parents("tr").find("td").eq(1).html();
        direccion= target.parents("tr").find("td").eq(2).html();
        telefono= target.parents("tr").find("td").eq(3).html();
        dpi= target.parents("tr").find("td").eq(4).html();
        nacimiento= target.parents("tr").find("td").eq(5).html();
        labores= target.parents("tr").find("td").eq(6).html();
        ingreso=target.parents("tr").find("td").eq(7).html();

        $("#txt_id").val(id);
        $("#txt_nombres").val(nombres);
        $("#txt_apellidos").val(apellidos);
        $("#txt_direccion").val(direccion);
        $("#txt_telefono").val(telefono);
        $("#txt_DPI").val(dpi);
        $("#txt_fn").val(nacimiento);
        $("#fecha_factura").val(ingreso);
        $("#txt_fil").val(labores);
        $("#drop_list").val(id_p);
        $("#modal_empleado").modal('show');
    });
    </script>
    <%}else{
        response.sendRedirect("index.jsp");}
            }else{
        response.sendRedirect("login.jsp");}
    %>
    </body>
</html>

