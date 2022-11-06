


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="modelo.Menu"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="styles2.css">
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="main.js"></script>
</head>
    <body>
        <%HttpSession sesion= (HttpSession) request.getSession(); %>
            <header>
		<!-- Esta pagina web la tienen que colocar en todas las nuevas que creen 
                     la colocan hasta arriba, se importa del siguiente modo:
                     < %@include file="header.jsp" %>
                      ^
                      Borrar este espacio sino no funcionara.
                      
                      Si tienen duda de como hacerlo vean el archivo index.jsp en la linea 10 :p
                     -->
                <div class="menu_bar">
			<a href="#" class="bt-menu"><span class="fas fa-bars"></span>Menú</a>
		</div>
                     
                     <nav>
                    
			<ul>    
                                 <li><a href="index.jsp" style='text-decoration: none; color: #FFFFFF'>Inicio</a></li>
                                <%
                                Menu menu = new Menu(); 
                                String aux = (String)session.getAttribute("user"); 
                                //;
                                menu.Pureba(aux);
                                if(menu.getProductos()==1){
                                menu.LeerUrl(1);
                                out.println("<li class='submenu'><a href='#' style='text-decoration: none; color: #FFFFFF'>"+menu.getNombre()+"</a>");
                                out.println("<ul class='children'>");
						 //
                                                 out.println("<li><a href='"+menu.getRuta()+"' style='text-decoration: none;'>Ver productos</a></li>");
						 if(menu.getMarcas()==1){
                                                    menu.LeerUrl(2);
                                                    out.println("<li><a href='"+menu.getRuta()+"' style='text-decoration: none; color: #FFFFFF'>"+menu.getNombre()+"</a></li>");
                                                 }
					out.println("</ul></li>");
                                }
                                if(menu.getMarcas()==1 && menu.getProductos()!=1){
                                                    menu.LeerUrl(2);
                                                    out.println("<li><a href='"+menu.getRuta()+"' style='text-decoration: none; color: #FFFFFF'>"+menu.getNombre()+"</a></li>");
                                }
                                
                                if(menu.getEmpleados()==1){
                                menu.LeerUrl(3);
                                out.println("<li class='submenu'><a href='#' style='text-decoration: none; color: #FFFFFF'>"+menu.getNombre()+"</a>");
                                out.println("<ul class='children'>");
						 //
                                                 out.println("<li><a href='"+menu.getRuta()+"' style='text-decoration: none;'>Ver Empleados</a></li>");
						 if(menu.getPuestos()==1){
                                                    menu.LeerUrl(5);
                                                    out.println("<li><a href='"+menu.getRuta()+"' style='text-decoration: none; color: #FFFFFF'>"+menu.getNombre()+"</a></li>");
                                                 }
					out.println("</ul></li>");    
                                }
                                if(menu.getPuestos()==1 && menu.getEmpleados()!=1){
                                                    menu.LeerUrl(5);
                                                    out.println("<li><a href='"+menu.getRuta()+"' style='text-decoration: none; color: #FFFFFF'>"+menu.getNombre()+"</a></li>");
                                                 }
                                if(menu.getClientes()==1){
                                menu.LeerUrl(6);
                                out.println("<li><a href='"+menu.getRuta()+"' style='text-decoration: none; color: #FFFFFF'>"+menu.getNombre()+"</a></li>");
                                }
                                if(menu.getProveedores()==1){
                                menu.LeerUrl(7);
                                out.println("<li><a href='"+menu.getRuta()+"' style='text-decoration: none; color: #FFFFFF'>"+menu.getNombre()+"</a></li>");
                                }
                                if(menu.getVentas()==1){
                                menu.LeerUrl(8);
                                out.println("<li><a href='"+menu.getRuta()+"' style='text-decoration: none; color: #FFFFFF'>"+menu.getNombre()+"</a></li>");
                                }
                                if(menu.getCompras()==1){
                                menu.LeerUrl(4);
                                out.println("<li><a href='"+menu.getRuta()+"' style='text-decoration: none; color: #FFFFFF'>"+menu.getNombre()+"</a></li>");
                                }
                                if(menu.getUsuarios()==1){
                                menu.LeerUrl(9);
                                out.println("<li><a href='"+menu.getRuta()+"' style='text-decoration: none; color: #FFFFFF'>"+menu.getNombre()+"</a></li>");
                                }%>   
                                <li><a href="login.jsp" style='text-decoration: none; color: #FFFFFF'>Cerrar Sesion</a></li>
                     
                                
                                
				<!--<li><a href="index.jsp" style="text-decoration: none;color: #FFFFFF">Inicio</a></li>
				<li class="submenu">
                                        
					<a href="#" style="text-decoration: none;color: #FFFFFF">Productos</a>
					<ul class="children">
						<li><a href="productos.jsp" style="text-decoration: none;">Ver productos</a></li>
						<li><a href="marcas.jsp" style="text-decoration: none;">Ver Marcas</a></li>
					</ul>
				</li>
                                <%
                                //if((sesion.getAttribute("Tipo")=="admin")||((sesion.getAttribute("Tipo")=="gerente"))){
                                //out.println("Hola");
                                %>
                                <li class="submenu"><a href="#" style="text-decoration: none;color: #FFFFFF">Empleados</a>
                                        <ul class="children">
                                            <li><a href="empleados.jsp" style="text-decoration: none;">Ver Empleados</a></li>
                                            <li><a href="puestos.jsp" style="text-decoration: none;">Ver Puestos</a></li>
					</ul></li>
                                
				<li><a href="clientes.jsp" style="text-decoration: none; color: #FFFFFF">Clientes</a></li>
				<li><a href="proveedores.jsp" style="text-decoration: none; color: #FFFFFF">Proveedores</a></li>
                                <%//} %>
				<%
                                //if(sesion.getAttribute("Tipo")=="admin"){
                                //out.println("Hola");
                                %>
                                <li><a href="#" style="text-decoration: none;color: #FFFFFF">Usuarios</a></li>
                                <%//} %>
                                <li><a href="sr_cerrarS" style="text-decoration: none;color: #FFFFFF">Cerrar Sesion</a></li>-->
			</ul>
		</nav>
	</header>
       
    </body>
</html>
