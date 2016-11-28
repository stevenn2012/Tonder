<%@page import="co.edu.usa.adf.Tonder.logic.TonderLogic"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.TreeMap"%>
<%@page import="co.edu.usa.adf.Tonder.datos.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.HashSet"%>
<%@page import="co.edu.usa.adf.Tonder.controller.HomeController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-tokenfield.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/css/bootstrap-formhelpers.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/form.css" />" rel="stylesheet">



<title>Home</title>
</head>
<body>
	<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
		<div class="container">

			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> Menu <i
						class="fa fa-bars"></i>
				</button>
				<a class="navbar-brand " href="">Tonder</a>
			</div>


			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a class="page-scroll" href="#">Sign Up / login</a></li>
				</ul>
			</div>

		</div>
	</nav>

	<div id="header">
		<div class="container">
			<div class="row">

				<div class="header-content inner">

					<div class="row">
						<div class="col-lg-4">
							<div class="wrap-per">
							<h3>Persona</h3>
							<p>Nombre : <%= HomeController.persona.getNombre() %></p>
							<p>Apellido : <%= HomeController.persona.getApellido() %></p>
							<p>Usuario : <%= HomeController.persona.getUsuario() %></p>
							<p>Correo : <%= HomeController.persona.getCorreo() %></p>
							<p>Sexo : <%= HomeController.persona.getSexo() %></p>
							<p>Orientacion : <%= HomeController.persona.getOrientacionSexual() %></p>
							<p>fecha de nacimiento : <%= HomeController.persona.getFechaNacimiento() %></p>
							<p>color favorito : <%= HomeController.persona.getColor() %></p>
							<p>about : <%= HomeController.persona.getAbout() %></p>
							<p>Pais : <%= HomeController.persona.getPais() %></p>
							<p>Ciudad : <%= HomeController.persona.getCiudad() %></p>
							<label>Hobbies :</label>
							<% for(int i = 0; i < HomeController.persona.getHobbies().size() ; i++){
								if(i != HomeController.persona.getHobbies().size()-1 ){
								%>
							<label><%= HomeController.persona.getHobbies().get(i).getNombre() %> , </label>
							<%		}else{
								%>
								<label><%= HomeController.persona.getHobbies().get(i).getNombre() %>  </label>
								<%
										}
									}
								%>
							</div>
							
							
						</div>
						<div class="col-lg-8">
						<div class ="wrap-per">
							<%
								TreeMap<Integer, Double> personas = HomeController.compatible;
								Set<Integer> keys = new HashSet<Integer>();
								keys = personas.keySet();
								
								List<Integer> lista = new ArrayList<Integer>(keys);
			
								for (int i = 0; i < lista.size(); i++) {
									%>
									<div class="persona">
									<label>Porcentaje :<%= personas.get(lista.get(i)) %> , </label>
									<label>Nombre :<%= TonderLogic.buscarPersonaPorId(lista.get(i)).getNombre() %> , </label>
									<label>Apellido :<%= TonderLogic.buscarPersonaPorId(lista.get(i)).getUsuario() %> , </label>
									<label>Usuario :<%= TonderLogic.buscarPersonaPorId(lista.get(i)).getUsuario() %> , </label>
									<label>Correo :<%= TonderLogic.buscarPersonaPorId(lista.get(i)).getColor() %> , </label>
									<label>Sexo :<%= TonderLogic.buscarPersonaPorId(lista.get(i)).getSexo() %> , </label>
									<label>Orientacion :<%= TonderLogic.buscarPersonaPorId(lista.get(i)).getOrientacionSexual() %> , </label>
									<label>Fecha de nacimiento :<%= TonderLogic.buscarPersonaPorId(lista.get(i)).getFechaNacimiento() %> , </label>
									<label>Color favorito<%= TonderLogic.buscarPersonaPorId(lista.get(i)).getColor() %> , </label>
									<label>About :<%= TonderLogic.buscarPersonaPorId(lista.get(i)).getAbout() %> , </label>
									<label>Pais :<%= TonderLogic.buscarPersonaPorId(lista.get(i)).getPais() %> , </label>
									<label>Ciudad<%= TonderLogic.buscarPersonaPorId(lista.get(i)).getCiudad() %> , </label>
									<%
									 for(int j = 0; j < TonderLogic.buscarPersonaPorId(lista.get(i)).getHobbies().size() ; j++){
										 if(j != HomeController.persona.getHobbies().size()-1 ){
									%>
									<label><%= TonderLogic.buscarPersonaPorId(lista.get(i)).getHobbies().get(j).getNombre() %> , </label>
									<%		}else{
								%>
								<label><%=  TonderLogic.buscarPersonaPorId(lista.get(i)).getHobbies().get(j).getNombre() %>  </label>
								
						
									<%
										}
									 }
									%>
									</div>
									<hr>
									<%
								}
							%>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<script src="<c:url value="/resources/js/jquery.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
	<script src="<c:url value="/resources/js/script.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap-tokenfield.js" />"></script>
	<script
		src="<c:url value="/resources/js/bootstrap-formhelpers.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.backstretch.js" />"></script>
	<script src="<c:url value="/resources/js/form.js" />"></script>

</body>
</html>
