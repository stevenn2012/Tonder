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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Plataforma</h1>
	<%
		out.println(HomeController.persona+"<br><br>");
		
		TreeMap<Integer, Double> personas = HomeController.compatible;
		Set<Integer> keys= new HashSet<Integer>();
		keys=personas.keySet();
		System.out.println(personas);
		List<Integer> lista = new ArrayList<Integer>(keys);
		out.println("Cantidad de personas: "+lista.size()+" <br>");
		for (int i = 0; i < lista.size(); i++) {
			out.println("id: "+lista.get(i)+", Nombre: "+TonderLogic.buscarPersonaPorId(lista.get(i))+" <br>");
			out.println("Porcentaje: "+personas.get(lista.get(i))+"<br><br>");
		}
	%>
</body>
</html>