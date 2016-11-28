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

	<header>
		<div class="container">
			<div class="row">
				<div class="row">

					<div id="formu"
						class="col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2 col-lg-6 col-lg-offset-3 form-box">
						<div class="btn-group" role="group" aria-label="Basic example">
							<button id="sign" type="button" class="btn btn-success">Sign
								In</button>
							<button id="in" type="button" class="btn btn-info">Login</button>
						</div>
						<br>
						<br>
						<br>
						<div id="inicio">
							<form:form  method="post" class="f1" action="/inicio" modelAttribute="persona">
								<div class="form-group">
									<form:input path="usuario" type="text" class="form-control"
										placeholder="Usuario" />
								</div>
								<div class="form-group">
									<form:input path="password" type="password"
										class="form-control" placeholder="contraseña" />
								</div>
								<input type="submit" class=" btn btn-submit" value ="Ingresar">
							</form:form>
						</div>
						<div id="regi">
							<form:form action="/addPerson" modelAttribute="persona"
								method="post" class="f1">



								<br>
								<br>

								<h3>Registrate</h3>
								<div class="f1-steps">
									<div class="f1-progress">
										<div class="f1-progress-line" data-now-value="16.66"
											data-number-of-steps="3" style="width: 16.66%;"></div>
									</div>
									<div class="f1-step active">

										<p>Informacion</p>
									</div>
									<div class="f1-step">

										<p>Social</p>
									</div>
									<div class="f1-step">
										<p>paso final</p>
									</div>
								</div>

								<fieldset>
									<h4>Tu informacion</h4>
									<div class="form-group">

										<form:input path="nombre" type="text" name="f1-first-name"
											placeholder="Nombres " class="f1-first-name form-control"
											id="f1-first-name" />
									</div>

									<div class="form-group">
										<form:input path="apellido" type="text" name="f1-last-name"
											placeholder="Apellidos" class="f1-last-name form-control"
											id="f1-last-name" />
									</div>

									<div class="form-group">
										<form:input path="usuario" type="text" class="form-control"
											placeholder="Usuario" />
									</div>
									<div class="form-group">
										<form:input path="password" type="password"
											class="form-control" placeholder="contraseña" />
									</div>
									<div class="form-group">
										<form:input path="correo" type="text" class="form-control"
											placeholder="Correo Electronico" />
									</div>

									<div class="f1-buttons">
										<button type="button" class="btn btn-next">Siguiente</button>
									</div>
								</fieldset>

								<fieldset>
									<h4>Tu parte social :</h4>
									<div class="col-lg-6">

										<div class="form-group">
											<label for="sel1">Sexo</label>
											<form:select path="sexo" class="form-control" id="sel1">
												<option>M</option>
												<option>F</option>

											</form:select>
										</div>

									</div>
									<div class="col-lg-6">
										<div class="form-group">
											<label for="sel1">Orientacion Sexual</label>
											<form:select path="orientacionSexual" class="form-control"
												id="sel1">
												<option>M</option>
												<option>F</option>
											</form:select>
										</div>

									</div>
									<div class="col-lg-6">
										<div class="form-group ">
											<div class="col-xs-10">
												<form:input path="fechaNacimiento" class="form-control"
													type="date" id="example-date-input" />
											</div>
										</div>
									</div>
									<div class="col-lg-6">
										<div class="form-group">
											<form:input path="color" type="text" class="form-control"
												placeholder="Color Favorito" />
										</div>
									</div>
									<div class="form-group">

										<form:textarea path="about" name="f1-about-yourself"
											placeholder="Sobre ti" class="f1-about-yourself form-control"
											id="f1-about-yourself"></form:textarea>
									</div>

									<div class="f1-buttons">
										<button type="button" class="btn btn-previous">Anterior</button>
										<button type="button" class="btn btn-next">Siguiente</button>
									</div>
								</fieldset>

								<fieldset>
									<h4>Subir foto</h4>
									<div class="form-group">
										<form:input path="rutaImagen" id="input-1" type="file"
											class="file" />
									</div>
									<h4>Hobbies:</h4>
									<div class="col-lg-12">

										<div class="form-group">

											<div class="col-lg-3">
												<form:input path="hobbie1" type="text" class="form-control" />
											</div>
											<div class="col-lg-3">
												<form:input path="hobbie2" type="text" class="form-control" />
											</div>
											<div class="col-lg-3">
												<form:input path="hobbie3" type="text" class="form-control" />
											</div>
											<div class="col-lg-3">
												<form:input path="hobbie4" class="form-control" />
											</div>
										</div>


									</div>
									<br> <br> <br>
									<div class="col-lg-6">
										<div>
											<form:select path="pais" id="countries_states1"
												class="form-control bfh-countries" data-country="US"></form:select>
										</div>


									</div>
									<div class="col-lg-6">

										<div>
											<form:select path="ciudad" class="form-control bfh-states"
												data-country="countries_states1"></form:select>
										</div>

									</div>


									<div class="f1-buttons ">
										<button type="button" class="pa btn btn-previous">Anterior</button>
										<input type="submit" class="pa btn btn-submit"
											value="Registrarse ">
									</div>
								</fieldset>
							</form:form>
						</div>
					</div>
				</div>
				<div class="header-content">





					<div class="header-content-inner">
						<h1>Encuentra a tu pareja perfecta dependiendo de tus gustos.
							Que estas esperando?</h1>
						<a id="start" href="#" class="btn btn-outline btn-xl page-scroll">INICIA
							AHORA</a>
					</div>
				</div>
			</div>
		</div>
	</header>
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
