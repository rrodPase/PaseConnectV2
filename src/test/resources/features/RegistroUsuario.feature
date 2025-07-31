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
      Then Usuario Registrado Correctamente