<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="stylesheet" href="css/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/cssPagAdmin/loginAdmin.css">
</head>
<body>
    <main>
        <form>
            <div class="titulo">
                <h2>BIENVENIDO PRUEBA1</h2>
                <!-- <img class="logo" src="../img/logo.png" alt=""> -->
            </div>
            <div class="form-group">
                <div class="Icon">
                    <i class="fa fa-user fa-3x" aria-hidden="true"></i>
                </div>
                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingresar Usuario">
            </div>
            <div class="form-group">
                <div class="Icon">
                    <i class="fa fa-unlock-alt fa-3x" aria-hidden="true"></i>
                </div>
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Ingresar contraseña">
            </div>
            <div class="boton">
                <button type="submit" class="btn btn-primary"><a href="AdminLobby.jsp">INICIAR SESION</a></button>
            </div>
          </form>
    </main>
</body>
</html>