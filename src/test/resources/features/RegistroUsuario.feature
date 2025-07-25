Feature: LoginEjecutivo

  Background:
    Given Usuario ingresa a la pagina de login

    Scenario: Usuario se registra en el sitio
      Given Ingresa opcion de registro
      And Selecciona perfil "Cliente Corporativo"
      When Ingresa a TMail "Nocorreo" y "Nopass"
      And Completa formulario de registro
      Then Se registra con exito