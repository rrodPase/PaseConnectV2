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

  Scenario: Creacion de Codigo Descuento
    Given El usuario ingresa con las credenciales "adminpase@mechanicspedia.com" y "Pass1*"
    And Da clic en el boton "Iniciar sesión"
    Then Se valida el ingreso a la verificación de dos pasos
    When El usuario accede a TMail e inicia sesión con las credenciales "adminpase@mechanicspedia.com" y '+-t=R"gu2!'
    Then El usuario accede correctamente a su cuenta
    And Navega a la sección "Membresías"
    Then Ingresa a "Configuración de códigos y mensajería"
    And Da clic en "Crear código de descuento"
    Then El usuario accede a la opción "Frecuencia de Pago"
    And Da clic en el botón "Abandonar"
    And Ingresa el texto "QAPrueAuto01" en el campo Nombre del Código
    And Selecciona la opción "Anual" en el menú Frecuencia de Pago
    And Ingresa el texto "QAPrueAuto01" en el campo Nombre del Código
    And Ingrese la cantidad de codigos "120"

