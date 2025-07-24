Feature: LoginEjecutivo

  Background:
    Given Usuario ingresa a la pagina de login

  Scenario: Usuario se loguea en el sitio como ejecutivo
    Given Ingresa con las siguientes credenciales "testejecutivo063@gmail.com" y "12345Ll@"
    And Da clic en iniciar sesion
    Then Usuario ingresa a su cuenta correctamente

  Scenario: Usuario se loguea en el sitio como mesa de control
    Given Ingresa con las siguientes credenciales "mesadecontrolmesadecontrol95@gmail.com" y "12345Mm@"
    And Da clic en iniciar sesion
    Then Usuario ingresa a su cuenta correctamente

  Scenario: Usuario se loguea en el sitio como legal
    Given Ingresa con las siguientes credenciales "testejecutivo063+legal@gmail.com" y "12QWas.."
    And Da clic en iniciar sesion
    Then Usuario ingresa a su cuenta correctamente

  Scenario: Admin corp logra ingresar al sitio
    Given Ingresa con las siguientes credenciales "cemex@dcpa.net" y "Pass1*"
    And Da clic en iniciar sesion
    Then Se valida ingreso a twofactor
    When Ingresa a TMail para obtener e inicia sesion con credenciales "cemex@dcpa.net" y "cemex"
    Then Usuario ingresa a su cuenta correctamente