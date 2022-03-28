#language: es

Característica: Como cliente de automationpractice
  necesito registrarme en la plataforma de automationpractice
  con el fin de poder obtener una cuenta en la plataforma.

  Antecedentes: que el cliente se encuentra en el landing page de la pagina web.

  @Regresion
  Esquema del escenario: : Registro exitoso con los campos obligatorios.
    Dado que el cliente se encuentra en el landing page de la pagina web
    Cuando el cliente navega y entra a la opcion de login
    Y el cliente ingresa un correo valido para el registro "calymony" y presiona crear un nuevo usuario
    Y ha llenado los campos obligatorios para el registro y enviado
    |firstName|<firstName>|
    |lastName|<lastName>|
    |password|<password>|
    |address|<address>|
    |city|<city>|
    |state|<state>|
    |zipCode|<zipCode>|
    |country|<country>|
    |mobilePhone|<mobilePhone>|
    Entonces el sistema debera mostrar en pantalla funciones para el manejo de mis datos y ordenes
  Ejemplos:
    |firstName|lastName|password|address|city|state|zipCode|country|mobilePhone|
    |Caly|Man|calyman|Mza 38 C 3 B La Churria|Pereira|Florida|60000|United States|0363130256|

  @Regresion
  Esquema del escenario: : Registro fallido con los campos obligatorios menos la contrasena
    Dado que el cliente se encuentra en el landing page de la pagina web
    Cuando el cliente navega y entra a la opcion de login
    Y el cliente ingresa un correo valido para el registro "calymony" y presiona crear un nuevo usuario
    Y ha llenado los campos obligatorios para el registro menos la contrasena y enviado
    |firstName|<firstName>|
    |lastName|<lastName>|
    |address|<address>|
    |city|<city>|
    |state|<state>|
    |zipCode|<zipCode>|
    |country|<country>|
    |mobilePhone|<mobilePhone>|
    Entonces el sistema debera mostrar en pantalla un mensaje de error indicando que la contrasena es requerida
  Ejemplos:
    |firstName|lastName|address|city|state|zipCode|country|mobilePhone|
    |Caly|Man|Mza 38 C 3 B La Churria|Pereira|Florida|60000|United States|0363130256|