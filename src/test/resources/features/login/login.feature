#language: es

Característica: Como cliente de automationpractice
  necesito loguearme en la plataforma de automationpractice
  con el fin de poder acceder a las funciones de mi cuenta en la plataforma.

  Antecedentes: el usuario ya posee una cuenta registrada en la plataforma
  Y que el cliente se encuentra en el landing page de la pagina web

  Esquema del escenario: Ingreso exitoso con los campos obligatorios.
    Dado que el cliente se encuentra en el landing page de la pagina web
    Cuando el cliente navega y entra a la opcion de login
    Y ha llenado con sus credenciales y enviado
    |emailAddress|<emailAddress>|
    |password|<password>|
    Entonces el sistema debera mostrar en pantalla funciones para el manejo de mis datos y ordenes
  Ejemplos:
    |emailAddress|password|
    |calyman@gmail.com|calymandela|

  Esquema del escenario: Ingreso fallido con los campos obligatorios y contraseña erronea.
    Dado que el cliente se encuentra en el landing page de la pagina web
    Cuando el cliente navega y entra a la opcion de login
    Y ha llenado con credenciales erroneas y enviado
      |emailAddress|<emailAddress>|
      |password|<password>|
    Entonces el sistema debera mostrar en pantalla un mensaje de error indicando que la autenticacion fallo
  Ejemplos:
    |emailAddress|password|
    |calyman@gmail.com|calyman|