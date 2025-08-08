Feature: Creación de cupo corresponsal bancario
  Background:
    Given que el usuario se encuentra en la pagina de Login
    When el especialista digita su usuario y contraseña correcto
    #And al dar clic en la opcion Creación Coba

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
  #TC_Validacion rechazos creacion Corresponsal
  Scenario Outline: Rechazos creación coba
    Given estoy en la pantalla de creacion Coba
    When se haga la consulta del "<numero_documento>" cliente
    And se ingrese "<codigo_oficina>"
    And se de clic en el boton Solicitar cupo
    Then al hacer las validaciones de motor se debe mostrar el "<motivo_rechazo>"

    Examples:
      | numero_documento | codigo_oficina | motivo_rechazo                                        |
      | 98500501         | 0012           | "Los datos seguros del cliente no están actualizados" |
      | xxxxxxxx         | 0019           | "El estudio es negativo porque no han pasado 6 meses desde el último aumento o creación del cupo" |
      | 98400402         | 0021           | "El resultado del estudio es negativo porque el corresponsal tiene cuentas embargadas en el Banco de Bogotá" |
      | 20390847         | 0013           | "El resultado del estudio es negativo porque no cumples con las políticas internas del Banco de Bogotá." |

 ## Formularios
  # TC_Formulario Datos cliente en Camara de comercio
  Scenario Outline: Formulario clientes en Cámara de Comercio
    Given estoy en la pantalla de creacion Coba
    When se haga la consulta del "<numero_documento>" cliente
    And se ingrese "<codigo_oficina>"
    And se de clic en el boton Solicitar cupo
    And estoy en la pantalla cliente cumple con los requisitos
    And se presione click en el botón Diligenciar formulario
    Then el campo "<Razon_social>"  debe tener el dato "<información>"

    Examples:
      | Razon_social | información     |
      | 80802884     | "Pacto Company" |
      | 80802885     | ""              |

  # TC_Campos obligatorios Formulario Datos cliente
  Scenario Outline: Formulario Datos completos
    Given estoy en el formulario: Verifica y actualiza la información del negocio según los datos registrados en Cámara de Comercio
    When se diligencien correctamente todos los campos del formulario
    Then el boton tiene el "<estado>"

    Examples:
      | estado       |
      | Habilitado   |
      | Inhabilitado |



  # TC_Campo Cuenta de ahorros o cuenta corriente
  # TC_Campos obligatorios Formulario Datos cliente
  Scenario Outline: Formulario Datos completos
    Given estoy en el formulario: Verifica y actualiza la información del negocio según los datos registrados en Cámara de Comercio
    When se cargaron los datos del cliente "<cedula>" y se da click en la lista desplegable del campo "Cuenta para pago de comisiones"
    Then se despliegan "<numero_cuenta>"

    Examples:
      | cedula       |numero_cuenta |
      | xxx          | xxxxxxx      |
      | xxxxx        | xxxxxxx      |

  # TC_Campo tipo de comisiones por que