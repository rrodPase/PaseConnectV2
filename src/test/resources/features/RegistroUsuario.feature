Feature: LoginEjecutivo

  Background:
    Given Usuario ingresa a la pagina de login

    Scenario: Usuario se registra en el sitio
      Given Ingresa opcion de registro
      And Selecciona perfil "Cliente Corporativo"
      When Ingresa a TMail "Registro" y "Usuario"
      And Completa formulario de registro
      Then Se registra con exito
      When Ingresa a TM para recibir correo de confirmacion
      And Llena la informacion de contraseña y acepta
      And Usuario Registrado Correctamente e ingresa a su cuenta
      When Inicia sesion con su nueva cuenta
      And Da clic en iniciar sesion
      Then Usuario ingresa a su cuenta correctamente
      And Completa informacion de Direccion fiscal


