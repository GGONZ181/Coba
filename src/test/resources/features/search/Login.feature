Feature: Autenticación de usuario en la pagina web COBA

Background:
	Given que el usuario se encuentra en la pagina de Login

	@LoginExitoso
	Scenario: Inicio de sesión Exitoso
	#When el especialista digita su usuario y contraseña correcto
	When el especialista digita su "iparada" y "Bogota123*" correcto
	Then valida el texto de la pagina
	#pruebasonia


	#intento 1
	@LoginIncorrecto1
	Scenario Outline: Inicio de sesión con credenciales incorrectas primer intento
	When el especialista digita el "<usuario>" y la "<clave>"
	Then valida mensaje de error intento uno

	Examples:
	  | usuario         | clave     |
	  | usuario_falso   | password123    |


	#intento 2
	@LoginIncorrecto2
	Scenario Outline: Inicio de sesión con credenciales incorrectas segundo intento
	When el especialista digita el usuario "<usuario>" y la contraseña "<clave>"
	 # por segunda vez
	Then muestra mensaje Te quedan 1 intentos de ingreso o se bloqueará el usuario
	And esta es pruebas que necesito hacer

	Examples:
	  | usuario            | clave          |
	  | usuario_falsodos   | password123    |


	#intento 3
	Scenario Outline: Inicio de sesión con credenciales incorrectas tercer intento
	When el especialista digita el usuario "<usuario>" y la contraseña "<clave>"
	Then muestra mensaje "Excediste el número de intentos"

	Examples:
	  | usuario         | clave     |
	  | usuario_falso   | password123    |

	#Sesion abierta
	Scenario: Ingresar portal coba con sesion abierta
    When en otro navegador o pestaña digita correctamente el usuario y la contraseña
    And ya se tiene una sesion abierta
    Then se muestra el modal Deseas ingresar al portal COBA desde esta ventana

	#Redireccion Desbloquo virtual
	Scenario: Redireccion a desbloqueo virtual
	Given que estoy en el modal de excediste numero de intentos
	When de click en el boton desbloqueo virtual
	Then redireccion a pagina del banco con titulo "Bienvenido (a) a desbloqueos y reinicios"


#Feature: Sesion abierta en portal COBA otro dispositivo
#Background:
	#Given que el usuario se encuntra en el modal de sesion abierta

	#Scenario: Boton regresar modal deseas ingresar al portal COBA desde esta ventana
	#When le de clic en el boton regresar
	#Then se debe devolver mostrando la pantalla del login del portal coba

	#Scenario: Boton ingresar aquí deseas ingresar al portal COBA desde esta ventana
	#When le de clic en el boton ingresar aquí
	#Then inicia sesion de esa pestaña
	#And la otra pestaña hace el cierre de sesion #Averiguar como se valida este cerrado de sesión

