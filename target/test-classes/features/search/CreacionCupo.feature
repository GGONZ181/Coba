Feature: Creación de cupo corresponsal bancario
  Background:
    Given que el usuario se encuentra en la pagina de Login
    When el especialista digita su usuario y contraseña correcto
    #And al dar clic en la opcion Creación Coba
    Then valida el texto de la pagina

    ## Login Exitoso


  #TC_Direccionamiento a la pantalla Creación coba
    Given estoy en portal coba
    When  de clic en la seccion Creción Coba
    Then se debe direccionar a esa pantalla
    And valida el texto de la pantalla

  #TC_Cliente registrado en crm
    Given estoy en Creación coba
    When se haga la consulta del cliente
    And el cliente esta registrado en CRM
    Then mostrar la información del cliente y los campos:
          |Grupo étnico|
          |Ingresa los 4 digitos de la oficina|
    And deshabilitado el botón Solicitar cupo

  #TC_Validaciones pantalla Ingresa los datos del cliente
    Given estoy en Creación coba
    When se diligencie en el campo buscador
    Then debe tener las siguientes validaciones: Minimo 6 caracteres
    And campo sea obligatorio

  #TC_Cliente no registrado en crm
    Given estoy en Creación coba
    When se haga la consulta cliente
    And no esta registrado en crm
    Then mostrar que el cliente no estra registrado y los campos:nombre cliente, correo y el botón enviar correo deshabilitado

  #TC_Modal Solicitud abierta y en trámite
    Given estoy en Creación coba
    When se haga la consulta del cliente
    And ya tiene una solicitud
    Then debe aparecer el modal Solicitud abierta y en trámite

  #TC_Cliente ya tiene cuenta
    Given estoy en Creación coba
    When se haga la consulta del cliente
    And ya tiene cuenta coba
    Then debe aparecer el modal No es posible realizar este tipo de solicitud

  #TC_El cliente cumple con los requisitos
    Given estoy en la pantalla Creación coba
    When ya se ha consultado exitosamente el cliente
    And se diligencia los campos Grupo etnico y oficina
    And se da clic en el boton Solicitar cupo
    And el motor hace las validaciones
    And cumpla los requisitos
    Then debe mostrar la pantalla El cliente cumple con los requisitos

  #TC_Validacion Campo Ingresa tu grupo etnico
    Given estoy en Creación coba
    When ya se ha consultado exitosamente el cliente
    And le de clic en la lista desplegable del campo grupo étnico
    And seleccione la opción Otro
    Then se habilita campo Ingresa tu grupo étnico
    And el campo llamado Ingresa tu grupo étnico solo debe permitir digitar letras


 ## Rechazados
 ## Formularios