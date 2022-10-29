<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet icon" href="../img/logo.png">
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="css/cssPagAdmin/GeneralCRUD.css">
</head>
<body>
	<main>
		<div class="content">
			<div class="logo">
				<img class="imglogo" src="img/logo.png" alt="">
			</div>
			<div class="usuario">
				<div class="iconUsuario">
					<img src="img/login.png" alt="">
				</div>
				<div class="nombre">
					<h2>$NOMBRE$</h2>
				</div>
			</div>
			<div class="userMenu">
				<div class="userMenu">
					<div class="imgUser">
						<img src="img/login.png" alt="">
					</div>
					<h2>$full nombre$</h2>
				</div>
				<div class="menu">
					<h2>MENU</h2>
					<div class="accordion" id="accordionPanelsStayOpenExample">
						<div class="accordion-item colorAccordion">
							<h2 class="accordion-header " id="panelsStayOpen-headingOne">
								<button class="accordion-button " type="button"
									data-bs-toggle="collapse"
									data-bs-target="#panelsStayOpen-collapseOne"
									aria-expanded="true" aria-controls="panelsStayOpen-collapseOne">
									Mantenimiento</button>
							</h2>
							<div id="panelsStayOpen-collapseOne"
								class="accordion-collapse collapse show"
								aria-labelledby="panelsStayOpen-headingOne">
								<div class="accordion-body ">
									<li><a href="AdminAñadirProd.jsp">Añadir</a></li>
								</div>
								<div class="accordion-body">
									<li><a href="AdminListarProd.jsp">Actualizar</a></li>
								</div>
							</div>
						</div>
						<div class="accordion-item colorAccordion">
							<h2 class="accordion-header" id="panelsStayOpen-headingTwo">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse"
									data-bs-target="#panelsStayOpen-collapseTwo"
									aria-expanded="false"
									aria-controls="panelsStayOpen-collapseTwo">Reporte</button>
							</h2>
							<div id="panelsStayOpen-collapseTwo"
								class="accordion-collapse collapse"
								aria-labelledby="panelsStayOpen-headingTwo">
								<div class="accordion-body">
									<li><a href="">Reporte 1</a></li>
								</div>
								<div class="accordion-body">
									<li><a href="">Reporte 2</a></li>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="contenidoPrincipal">
				<h5 style="margin: auto; font-size: 90px;">BIENVENIDO</h5>
			</div>
		</div>
	</main>
</body>
</html>
