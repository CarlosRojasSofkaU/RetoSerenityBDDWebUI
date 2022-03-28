# Reto de automatización con Serenity BDD y WebUI
# Realizado por Carlos Fernando Rojas Cortés

En este proyecto se pretende realizar unas caracteristicas para un negocio bancario de pruebas, para practicar conocimientos como:

* Uso de metodología BDD
* Uso de lenguaje DSL y herramientas como Gherkin para su manejo
* Uso de Serenity BDD y cucumber para pruebas automatizadas
* Uso de gestores de log con log4j
* Uso de Screenplay como patrones de automatizaición
* Buenas prácticas de programación en la contrucción del caso de negocio
* Uso de lenguaje descriptivo en terminos de negocio

Para esto se definen las siguientes secciones:
  1. [Configuración inicial](#configuración-inicial)
  2. [Requerimientos](#requerimientos)
  3. [Plan de pruebas](#plan-de-pruebas)


## Configuración inicial

Para poder correr las pruebas automatizadas se debe ubicar en la ruta src/test/java/co/com/sofka/runner y posteriormente

en cualquiera de los paquetes que se encuentran allí (contactus, login, register), en ellos encontrará ejecutables java

que serán los que correran las pruebas automatizadas.


## Requerimientos

Para usar este proyecto es necesario tener los siguientes plugins en un IDE que maneje Java como lo puede ser IntelliJ IDEA además de contar con JDK11:

■CucumberforJava
■Gherkin
■SubstepsIntellijPlugin
■Gradle
■Maven

y dependencias como las de Serenity BDD, jackson, entre otras


## Plan de pruebas

### 1. **Descripción del plan de pruebas**

El proyecto de la automation practice tiene como objetivo principal implementar un canal virtual (sitio web) que le permita a sus clientes actuales o potenciales realizar funciones de registro, logueo y contacto.

Este plan de pruebas está enfocado a que el usuario pueda navegar por el sitio web y pueda realizar acciones de contacto al servicio al cliente, registro de un nuevo usuario a la plataforma y logueo de un usuario de la plataforma.

### 2. **Alcance de las pruebas**

El alcance de las pruebas para el primer sprint incluye pruebas para los módulos de Contact Us (Costumer Care), Register y Log In, basados en los siguientes criterios de aceptación:

1. Modulo "Contact Us"

*Verificar que cuando no se ingresa un campo obligatorio como el mensaje (problematica) el sistema arroja un mensaje de error, indicando que este campo es obligatorio.
*Verificar que cuando se llena el formulario correctamente (todos los campos obligatorios) el sistema arroja un mensaje de agradecimiento con el nombre del cliente que mandó el mensaje.

2. Modulo "Register"

*Verificar que cuando las contraseña ingresada es erronea, el sistema arroja un mensaje de error.
*Verificar que cuando el cliente se registra exitosamente (se llenan todos los campos obligatorios) el sistema arroja un mensaje de bienvenida con el nombre de usuario y un mensaje de bienvenida lateral con el nombre completo del usuario.

3. Modulo "Log In"

*Verificar que cuando el cliente ingresa las credenciales incorrectamente, el sistema arroja un mensaje diciendole al cliente que no se pudo autenticar correctamente.
*Verificar que cuando el cliente ingresa las credenciales correctamente, el sistema le muestra al cliente un resumen de su cuenta y le da funcionalidades extra al cliente como la de salir de la cuenta (Log Out).

### **Fuera de alcance**

*No se verificará la existencia mensajes de error de campos obligatorios en el formulario de contactanos, como lo son Email y Subject Heading.
*No se verificará la existencia mensajes de error de campos olbigatorios en el formulario de registro, como lo son First Name, Last Name, Adress, City, State, Zip Code, Username, Password.
*No se verificará el funcionamiento de funcionalidades extras al loguearse con una cuenta.
*No se verificarán otros módulos de la página web.

### 3. **Estrategia de las pruebas**

Las pruebas del primer sprint se realizarán de manera **automática**, estas se realizarán con ayuda de Serenity BDD y Cucumber. Se realizarán funcionalidades preestablecidas para los módulos de Contact Us (Customer Care), Register y Log In. Inicialmente se realizarán las pruebas en el navegador web **Google Chrome**

### Riesgos

A continuación se presenta una tabla con el análisis de riesgos para cada criterio de aceptación creados para los módulos en cuestión.

El análisis se realizó con una matriz de riesgos de 3x3, por lo tanto el menor nivel de riesgo será 1 y el mayor será 9.

| Criterio aceptación | Probabilidad | Impacto | Nivel de riesgo |
| --- | --- | --- | --- |
| CA_001 Verificar mensaje de obligatoriedad en el campo Message de Contatc Us | 1 | 1 | 1 |
| CA_002 Verificar submit de Contact Us exitoso | 1 | 3 | 3 |
| CA_003 Verificar mensaje de error en el login cuando las contraseña es erronea | 3 | 3 | 9 |
| CA_004 Verificar submit de registro exitoso | 2 | 3 | 6 |
| CA_005 Verificar mensaje de credenciales erroneas en Log In | 3 | 2 | 6 |
| CA_006 Verificación de logueo exitoso | 2 | 2 | 4 |

### 4. Requerimientos

- Requerimos acceso al servicio de la plataforma web de la empresa.
- Documentación actualizada del proyecto.
- Comunicación constante con el equipo de trabajo.


### 5. Otros tipos de pruebas

Se recomienda al equipo realizar las siguientes pruebas:

- Pruebas de Rendimiento
- Pruebas de Carga
- Pruebas de Seguridad

### 6. Equipo de trabajo

**Carlos Fernando Rojas Cortés** – Creador del plan de pruebas y automatizador