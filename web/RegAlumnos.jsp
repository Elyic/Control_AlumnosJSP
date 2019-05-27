<%-- 
    Document   : RegAlumnos
    Created on : 21-may-2018, 15:11:33
    Author     : Cristopher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Usuarios</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
   <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    </head>
    <body>
       <form class="needs-validation" novalidate>
        
  <div class="form-row" id="reg" >
    <div class="col-md-4 mb-3">
      <label for="validationCustom01">Nombre</label>
      <input type="text" class="form-control" id="validationCustom01" placeholder="nombre" value="Mark" required>
      <div class="valid-feedback">
        Looks good!
      </div>
    </div>
    <div class="col-md-4 mb-3">
      <label for="validationCustom02">Apellido</label>
      <input type="text" class="form-control" id="validationCustom02" placeholder="apellido" value="Otto" required>
      <div class="valid-feedback">
        Looks good!
      </div>
    </div>
    <div class="col-md-4 mb-3">
      <label for="validationCustomUsername">Usuario</label>
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" id="inputGroupPrepend">@</span>
        </div>
        <input type="text" class="form-control" id="validationCustomUsername" placeholder="Usuario" aria-describedby="inputGroupPrepend" required>
        <div class="invalid-feedback">
          Por favor escoja un nombre de usuario.
        </div>
      </div>
    </div>
 
  
    <div class="col-md-6 mb-3">
      <label for="validationCustom03">Departamento</label>
      <input type="text" class="form-control" id="validationCustom03" placeholder="Departamento" required>
      <div class="invalid-feedback">
        Por favor ingrese una ciudad correcta.
      </div>
    </div>
    <div class="col-md-3 mb-3">
      <label for="validationCustom04">Municipio</label>
      <input type="text" class="form-control" id="validationCustom04" placeholder="Municipio" required>
      <div class="invalid-feedback">
        por favor ingrese un departamento valido.
      </div>
    </div>
    <div class="col-md-3 mb-3">
      <label for="validationCustom05">Carrera</label>
      <input type="text" class="form-control" id="validationCustom05" placeholder="Carrera" required>
      <div class="invalid-feedback">
        Por Favor ingrese una carrera correcta.
      </div>
    </div>
 

      <button class="btn btn-primary" type="Registrar" ><a  id="Registrar" href="index.jsp">Registrar</a></button>
  </div>
</form>

<script>
// Example starter JavaScript for disabling form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();
</script>
    </body>
</html>
