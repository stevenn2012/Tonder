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
<link href="<c:url value="/resources/css/materialize.css" />"
	rel="stylesheet">

<link href="<c:url value="/resources/css/form.css" />" rel="stylesheet">



<title>Home</title>
</head>
<body>


	<nav>
		<div class="nav-wrapper  light-blue lighten-1">
			<div class="container">
				<a href="#" class="brand-logo">Plataforma</a>
				<ul id="nav-mobile" class="right hide-on-med-and-down">
					<li>Bienvenido : <%=HomeController.persona.getUsuario()%></li>
					<li><a href="/">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>



	<div id="header">
		<div class="row">
			<div class="derecha col l4">
				<div class="container">
					<div class="user-logo">
						<h1>Tonder</h1>
					</div>
					<hr>
					<div class="left wrap-per">
						<div class="row">
							<div class="col l12">
								<div class="card light-blue lighten-1">
									<div class="card-content white-text">
										<span class="card-title">Soy <%=HomeController.persona.getNombre()%>
											<%=HomeController.persona.getApellido()%></span>
										<p>
											Hoy soy de sexo
											<%=HomeController.persona.getSexo()%>
											y mi orientacion sexual es
											<%=HomeController.persona.getOrientacionSexual()%>. Naci el
											<%=HomeController.persona.getFechaNacimiento()%>
											en la ciudad de
											<%=HomeController.persona.getCiudad()%>
											en
											<%=HomeController.persona.getPais()%>
											, mi color favorito es
											<%=HomeController.persona.getColor()%>
											,
											<%=HomeController.persona.getAbout()%>
											y mis hobbies son
											<%
											for (int i = 0; i < HomeController.persona.getHobbies().size(); i++) {
												if (i != HomeController.persona.getHobbies().size() - 1) {
										%>
											<label><%=HomeController.persona.getHobbies().get(i).getNombre()%>
												, </label>
											<%
												} else {
											%>
											<label><%=HomeController.persona.getHobbies().get(i).getNombre()%>
											</label>
											<%
												}
												}
											%>
										</p>
									</div>
									<div class="card-action">
										<a href="#"><%=HomeController.persona.getCorreo()%></a>
									</div>
								</div>
							</div>
						</div>


					</div>
				</div>
			</div>
			<div class="personas col l8">

				<div class="wrap-per">
					<%
						TreeMap<Integer, Double> personas = HomeController.compatible;
						Set<Integer> keys = new HashSet<Integer>();
						keys = personas.keySet();

						List<Integer> lista = new ArrayList<Integer>(keys);

						for (int i = 0; i < lista.size(); i++) {
					%>
					<ul class="collapsible" data-collapsible="accordion">
						<li>
							<div class="collapsible-header">
								<label>Porcentaje : <%=personas.get(lista.get(i))%>
								</label><%=TonderLogic.buscarPersonaPorId(lista.get(i)).getUsuario()%>
							</div>
							<div class="collapsible-body">
								<div class="row">
									<div class="col l4">
										<p>
											Nombre :<%=TonderLogic.buscarPersonaPorId(lista.get(i)).getNombre()%>
											<%=TonderLogic.buscarPersonaPorId(lista.get(i)).getApellido()%>
										</p>
										<p>
											Sexo :<%=TonderLogic.buscarPersonaPorId(lista.get(i)).getSexo()%></p>
										<p>
											Orientacion :<%=TonderLogic.buscarPersonaPorId(lista.get(i)).getOrientacionSexual()%></p>
									</div>
									<div class="col l4">
										<p>
											Correo :<%=TonderLogic.buscarPersonaPorId(lista.get(i)).getCorreo()%></p>
										<p>
											Fecha de nacimiento :<%=TonderLogic.buscarPersonaPorId(lista.get(i)).getFechaNacimiento()%>

										</p>
										<p>
											Color favorito:
											<%=TonderLogic.buscarPersonaPorId(lista.get(i)).getColor()%>
										</p>
									</div>
									<div class="col l4">
										<p>
											About :
											<%=TonderLogic.buscarPersonaPorId(lista.get(i)).getAbout()%>

										</p>
										<p>
											Ciudad :
											<%=TonderLogic.buscarPersonaPorId(lista.get(i)).getCiudad()%>
											de
											<%=TonderLogic.buscarPersonaPorId(lista.get(i)).getPais()%>

										</p>
										<p>
											Hobbies :
											<%
											for (int j = 0; j < TonderLogic.buscarPersonaPorId(lista.get(i)).getHobbies().size(); j++) {
													if (j != HomeController.persona.getHobbies().size() - 1) {
										%>
											<label><%=TonderLogic.buscarPersonaPorId(lista.get(i)).getHobbies().get(j).getNombre()%>
												, </label>
											<%
												} else {
											%>
											<label><%=TonderLogic.buscarPersonaPorId(lista.get(i)).getHobbies().get(j).getNombre()%>
											</label>


											<%
												}
													}
											%>
										</p>
									</div>
								</div>
							</div>
						</li>
					</ul>
					<%
						}
					%>
				</div>
			</div>
		</div>

	</div>
	<script src="<c:url value="/resources/js/jquery.js" />"></script>
	<script src="<c:url value="/resources/js/materialize.js" />"></script>
	<script src="<c:url value="/resources/js/script.js" />"></script>
	<script src="<c:url value="/resources/js/form.js" />"></script>

</body>
</html>
