<%-- 
    Document   : index
    Created on : 26/09/2013, 02:57:49 PM
    Author     : saviasoft4
--%>

<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso PETI</title>
    </head>
    <body>
        <h1>PETI</h1>
        <input type="button" value="Control de Usuarios y Roles" 
               onClick="location.href = 'paginas/usuarios/usuarioLista.jsf'">
        <input type="button" value="Administración de Parámetros Generales" 
               onClick="location.href = 'paginas/parametros/parametroLista.jsf'">
    </body>
</html>--%>

<meta http-equiv="Cache-Control"
	content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />

<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%
	request.getSession().invalidate();
%>
<%
	response.sendRedirect("login");
%>