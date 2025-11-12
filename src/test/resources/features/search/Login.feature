Feature: Autenticación de usuario en la pagina web COBA

	Background:
		Given que el usuario se encuentra en la pagina de Login

	@LoginExitoso
	Scenario: Inicio de sesión Exitoso
		When el especialista digita su "iparada" y "Bogota123*" correcto
		Then valida el texto de la pagina


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
		When el especialista digita el usuario "<usuario>" y la contraseña "<clave>" incorrecta por segunda vez
		Then muestra mensaje Te quedan 1 intentos de ingreso o se bloqueará el usuario
		#And esta es pruebas que necesito hacer

		Examples:
			| usuario            | clave          |
			| usuario_falsodos   | password123    |


  	#intento 3
	@LoginIncorrecto3
	Scenario Outline: Inicio de sesión con credenciales incorrectas tercer intento
		When el especialista digita el usuario "<usuario>" y la contraseña "<clave>" incorrecta por tercera vez
		Then muestra mensaje Excediste el número de intentos

		Examples:
			| usuario         | clave     |
			| usuario_falsotres   | password123    |


#	#Redireccion Desbloquo virtual
#	@LoginBtnDesbloqueoVirtual
#	Scenario Outline: Redireccion a desbloqueo virtual luego de Inicio de sesión con credenciales incorrectas tercer intento
#		When el especialista digita el usuario "<usuario>" y la contraseña "<clave>" incorrecta por tercera vez y presiona boton Desbloqueo virtual
#		Then redireccion a pagina del banco de Desbloqueos y reinicios
#
#		Examples:
#			| usuario            | clave     |
#			| usuario_desbloqueo | DesbloqueoVirtual987    |
#
	#ojo falta la parte de que de clic al boton de desbloqueo y validar textos de esa pagina





#	#Sesion abierta
#	Scenario: Ingresar portal coba con sesion abierta
#    When en otro navegador o pestaña digita correctamente el usuario y la contraseña
#    And ya se tiene una sesion abierta
#    Then se muestra el modal Deseas ingresar al portal COBA desde esta ventana



#Feature: Sesion abierta en portal COBA otro dispositivo
#Background:
	#Given que el usuario se encuentra en el modal de sesion abierta

	#Scenario: Boton regresar modal deseas ingresar al portal COBA desde esta ventana
	#When le de clic en el boton regresar
	#Then se debe devolver mostrando la pantalla del login del portal coba

	#Scenario: Boton ingresar aquí deseas ingresar al portal COBA desde esta ventana
	#When le de clic en el boton ingresar aquí
	#Then inicia sesion de esa pestaña
	#And la otra pestaña hace el cierre de sesion #Averiguar como se valida este cerrado de sesión

