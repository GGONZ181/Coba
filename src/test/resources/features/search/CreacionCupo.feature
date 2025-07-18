Feature: Aumento de cupo al corresponsal bancario    
	
	#TC_Datos del corresponsal en CRM
    Scenario: Datos del corresponsal
    Given estoy en la pantalla aumento de cupo
    And se hace la consulta de algun cliente que existe en CRM
    And es corresponsal
    And no tiene una solicitud de aumento de cupo
    When se da clic en el botón buscar
    Then se muestra la pantalla "Datos del corresponsal en CRM"

    #TC_Corresponsal no aparece en CRM
	Scenario: Corresponsal no aparece en CRM
    Given Estoy en la pantalla aumento de cupo
    And se hace la consulta de algun cliente que no esta creado en CRM
    When se de clic en el botón buscar
    Then se muestra la pantalla "Corresponsal no aparece en CRM"
	
	#TC_Aumento rechazado
	Scenario: Aumento rechazado
    Given estoy en la pantalla "Datos del corresponsal en CRM"
    And se da clic en el botón continuar
    When se muestra las evaluciones del motor 
    Then el portal COBA hace el rechazo del aumento de cupo
    And en el voucher muestra el motivo del rechazo
 
    #TC_Aumento pausado
	Scenario: Aumento pausado
    Given estoy en la pantalla "Datos del corresponsal en CRM"
    And se da clic en el botón continuar
    And la evaluacion del motor es positiva
    When hace la evalucion de los de sobre giro entre 11-15 dias sobre giro  
    Then el portal COBA pausa el aumento
 
    #TC_Cliente no es corresponsal bancario
    Scenario: Cliente no es corresponsal bancario
    Given Estoy en aumento de cupo
    When se hace la consulta de algun cliente que esta en crm
    But no es corresponsal 
    And se da clic en el botón buscar
    Then se muestra la pantalla "Cliente no es corresponsal bancario"
	
	#TC_Corresponsal tiene una solicitud en curso
    Scenario: Corresponsal tiene una solicitud en curso
	Given estoy en aumento de cupo
    And se hace la consulta de algun cliente que esta en crm
    And es corresponsal
    But  tiene una solicitud
    When se da clic en el botón buscar
    Then se muestra la pantalla "Corresponsal tiene una solicitud en curso"
	
	#TC_Direccionamiento a la pantalla ajuste monto cupo
    Scenario: Direccionamiento a la pantalla ajuste monto cupo
	Given estoy en el voucher aumento preaprobado
    When se de clic en Si lo necesitas, ajusta el cupo aquí
	Then se debe direccionar a la pantalla Ajustar cupo de aumento
	
	#TC_Ajustar monto cupo pre aprobado
	Scenario: Ajustar monto cupo pre aprobado
	Given estoy en la pantalla Ajustar cupo de aumento
	When se modifique el monto pre aprobado
	And se de clic en el botón Aceptar
	Then en el voucher Aumento pre aprobado en el campo Cupo de sobregiro nuevo se debe visualizar ese monto
	
	#TC_Envio aprobacion aumento cupo
	Scenario: Envio aprobacion aumento cupo
	Given estoy en el voucher Aumento pre aprobado
	When se de clic en el botón Enviar aprobacion
	Then se sale un toast indicando lo siguiente: Se envió a xxxxxxxx y a xxxxx, un link para continuar la solicitud.
	And debe llegarle al correo de acuerdo a lo que esta en datos seguros
	And al numero celular que tenga en datos seguro indicando que le llego un link al correo
 
 

  