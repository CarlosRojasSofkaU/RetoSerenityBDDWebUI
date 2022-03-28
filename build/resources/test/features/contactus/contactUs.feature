#language: es

Característica: Como cliente de automationpractice
  necesito contactarme con el servicio al cliente
  con el fin de que le den una solucion a mi problematica.

  Antecedentes: que el cliente se encuentra en la landing page de la pagina web.

  @Regresion
  Esquema del escenario: Ingreso de una problematica con los campos obligatorios.
    Dado que el cliente se encuentra en la landing page de automationpractice
    Cuando el cliente navega y entra a la opcion de contactanos
    Y ha llenado los campos obligatorios y enviado
    |subjectHeading|<subjectHeading>|
    |emailAddress|<emailAddress>|
    |message|<message>|
    Entonces el sistema debera mostrar en pantalla un mensaje de operacion exitosa
  Ejemplos:
    |subjectHeading|emailAddress|message|
    |Webmaster     |calyman@gmail.com|Hello world|

  @Regresion
  Esquema del escenario: : Ingreso de una problematica con los campos obligatorios diligenciados menos el de mensaje.
    Dado que el cliente se encuentra en la landing page de automationpractice
    Cuando el cliente navega y entra a la opcion de contactanos
    Y ha llenado ciertos campos y enviado
      |subjectHeading|<subjectHeading>|
      |emailAddress|<emailAddress>|
    Entonces el sistema debera mostrar en pantalla un mensaje de error pidiendo que se envie un mensaje
    Ejemplos:
      |subjectHeading|emailAddress|
      |Webmaster     |calyman@gmail.com|