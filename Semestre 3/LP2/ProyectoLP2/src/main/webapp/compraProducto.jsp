<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Name Page</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet icon" href="img/logo.png">
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <link rel="stylesheet" type='text/css' media='screen' href='css/cssPagCliente/compraProducto.css'>
    <link rel="stylesheet" type='text/css' media='screen' href='css/cssPagCliente/header.css'>
    <link rel="stylesheet" type='text/css' media='screen' href='css/cssPagCliente/footer.css'>
</head>
<body>
    <header class="encabezado">
        <div class="logo">
            <a href="index.jsp">
                <img class="imgLogo" src="img/logo.png" alt="Imagenlogo">
            </a>
        </div>
    </header>

    <main>
        <div class="blockHome">
            <div class="datosUsuario">
                <div class="Usuario">
                    <div class="titulo">
                        <h2>Informacion del usuario</h2>
                    </div>
                    <div class="infoUser lineButton">
                        <div class="imagenUser">
                            <img src="img/login.png" alt="">
                        </div>
                        <div class="datosUser">
                            <h3>$Nombre cliente$ ($CORREO ELECTRONICO$)</h3>
                        </div>
                    </div>
                </div>
                <form>
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Tipo de documento :</label>
                        <div class="form-group">
                            <select name="cboCliente" class="form-control" >
                                <option value="">Seleccionar</option>
                                <option value="">1</option>
                                <option value="">2</option>
                                <option value="">3</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPantalla1">Numero de documento :</label> 
                        <input type="text" class="form-control" id="exampleInputoantalla" placeholder="Ingrese descripcion de pantalla" name="txtPantalla">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPantalla1">Numero telefonico :</label> 
                        <input type="text" class="form-control" id="exampleInputoantalla" placeholder="Ingrese descripcion de pantalla" name="txtPantalla">
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Pais :</label>
                        <div class="form-group">
                            <select name="cboCliente" class="form-control" >
                                <option value="">Seleccionar</option>
                                <option value="">1</option>
                                <option value="">2</option>
                                <option value="">3</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Ciudad :</label>
                        <div class="form-group">
                            <select name="cboCliente" class="form-control" >
                                <option value="">Seleccionar</option>
                                <option value="">1</option>
                                <option value="">2</option>
                                <option value="">3</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPantalla1">Numero de RUC :</label> 
                        <input type="text" class="form-control" id="exampleInputoantalla" placeholder="Ingrese descripcion de pantalla" name="txtPantalla">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPantalla1">Direccion :</label> 
                        <input type="text" class="form-control" id="exampleInputoantalla" placeholder="Ingrese descripcion de pantalla" name="txtPantalla">
                    </div>
                </form>
            </div>
            <div class="datosCarrito">
                <div class="productos">
                    <ol class="list-group list-group-numbered">
                        <li class="list-group-item d-flex justify-content-between align-items-start">
                            <div class="ms-2 me-auto">
                                <div class="fw-bold">LAPTOP</div>
                                Lenovo Legion
                            </div>
                            <div class="ms-2 me-auto">
                                <div class="imgItem">
                                    <img src="img/imgProductos/LaptopLenovo_Legion5_S1.jpg" alt="">
                                </div>
                            </div>
                            <div class="ms-2 me-auto">
                                <div class="fw-bold">CANTIDAD</div>
                                1
                            </div>
                            <div class="ms-2 me-auto">
                                <div class="fw-bold">PRECIO</div>
                                9999.99 PEN
                            </div>
                        </li>
                        
                      </ol>
                </div>
                <div class="total">
                    <div class="cartProducto lineButton">
                        <h5>Subtotal</h5>
                        <h5 class="subtotalProd">9999.99 PEN</h5>
                    </div>
                    <div class="cartProducto">
                        <h5>Total</h5>
                        <h5 class="todalProd">9999.99 PEN</h5>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <footer>
        <div class="pieDePagina">
            <div>
                <p>�2021 - Grupo Bombastic</p>
            </div> 
            <div>
                <img src="img/iconVisa.png" alt="">
                <img src="img/iconPagoEfectivo.png" alt="">
            </div>
        </div>
    </footer>
</body>
</html>