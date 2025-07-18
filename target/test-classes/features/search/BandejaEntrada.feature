Feature: Filtros de Bandeja de Entrada

    Background:
        Given que el usuario se encuentra en la bandeja de entrada

    #Todas
    Scenario Outline: Filtro de solicitudes por todos los estados
        When se selecciona el estado Todas
        And filtro "<identificacion>"
        And filtro "<tipo_solicitud>"
        And filtro "<numero>"
        And se oprima el boton filtrar
        Then debe mostrar los datos que cumplen con los filtros seleccionados

        Examples:
            | identificacion              | tipo_solicitud   | numero |
            | Todas                       | Todas            |        |
            | Todas                       | Creacion de Cupo |        |
            | Todas                       | Aumento de Cupo  |        |
            | C.C - Cedula de Ciudadania  | Todas            |        |
            | C.C - Cedula de Ciudadania  | Creacion de Cupo |        |
            | C.C - Cedula de Ciudadania  | Aumento de Cupo  |        |
            | C.E - Cedula de Extranjeria | Todas            |        |
            | C.E - Cedula de Extranjeria | Creacion de Cupo |        |
            | C.E - Cedula de Extranjeria | Aumento de Cupo  |        |


    #Rechazada
    Scenario Outline: Filtro de solicitudes por estado Rechazada
        When se selecciona el estado Rechazada
        And filtro "<identificacion>"
        And filtro "<tipo_solicitud>"
        And filtro "<numero>"
        And se oprima el boton filtrar
        Then debe mostrar los datos que cumplen con los filtros seleccionados

        Examples:
            | identificacion              | tipo_solicitud   | numero |
            | Todas                       | Todas            |        |
            | Todas                       | Creacion de Cupo |        |
            | Todas                       | Aumento de Cupo  |        |
            | C.C - Cedula de Ciudadania  | Todas            |        |
            | C.C - Cedula de Ciudadania  | Creacion de Cupo |        |
            | C.C - Cedula de Ciudadania  | Aumento de Cupo  |        |
            | C.E - Cedula de Extranjeria | Todas            |        |
            | C.E - Cedula de Extranjeria | Creacion de Cupo |        |
            | C.E - Cedula de Extranjeria | Aumento de Cupo  |        |


    #Exitosa
    Scenario Outline: Filtro de solicitudes por estado Exitosa
        When se selecciona el estado Exitosa
        And filtro "<identificacion>"
        And filtro "<tipo_solicitud>"
        And filtro "<numero>"
        And se oprima el boton filtrar
        Then debe mostrar los datos que cumplen con los filtros seleccionados

        Examples:
            | identificacion              | tipo_solicitud   | numero |
            | Todas                       | Todas            |        |
            | Todas                       | Creacion de Cupo |        |
            | Todas                       | Aumento de Cupo  |        |
            | C.C - Cedula de Ciudadania  | Todas            |        |
            | C.C - Cedula de Ciudadania  | Creacion de Cupo |        |
            | C.C - Cedula de Ciudadania  | Aumento de Cupo  |        |
            | C.E - Cedula de Extranjeria | Todas            |        |
            | C.E - Cedula de Extranjeria | Creacion de Cupo |        |
            | C.E - Cedula de Extranjeria | Aumento de Cupo  |        |


    #Pausada
    Scenario Outline: Filtro de solicitudes por estado Pausada
        When se selecciona el estado Pausada
        And filtro "<identificacion>"
        And filtro "<tipo_solicitud>"
        And filtro "<numero>"
        And se oprima el boton filtrar
        Then debe mostrar los datos que cumplen con los filtros seleccionados

        Examples:
            | identificacion              | tipo_solicitud   | numero |
            | Todas                       | Todas            |        |
            | Todas                       | Creacion de Cupo |        |
            | Todas                       | Aumento de Cupo  |        |
            | C.C - Cedula de Ciudadania  | Todas            |        |
            | C.C - Cedula de Ciudadania  | Creacion de Cupo |        |
            | C.C - Cedula de Ciudadania  | Aumento de Cupo  |        |
            | C.E - Cedula de Extranjeria | Todas            |        |
            | C.E - Cedula de Extranjeria | Creacion de Cupo |        |
            | C.E - Cedula de Extranjeria | Aumento de Cupo  |        |



    #En Proceso
    Scenario Outline: Filtro de solicitudes por estado En Proceso
        When se selecciona el estado En Proceso
        And filtro "<identificacion>"
        And filtro "<tipo_solicitud>"
        And filtro "<numero>"
        And se oprima el boton filtrar
        Then debe mostrar los datos que cumplen con los filtros seleccionados

        Examples:
            | identificacion              | tipo_solicitud   | numero |
            | Todas                       | Todas            |        |
            | Todas                       | Creacion de Cupo |        |
            | Todas                       | Aumento de Cupo  |        |
            | C.C - Cedula de Ciudadania  | Todas            |        |
            | C.C - Cedula de Ciudadania  | Creacion de Cupo |        |
            | C.C - Cedula de Ciudadania  | Aumento de Cupo  |        |
            | C.E - Cedula de Extranjeria | Todas            |        |
            | C.E - Cedula de Extranjeria | Creacion de Cupo |        |
            | C.E - Cedula de Extranjeria | Aumento de Cupo  |        |

    #Descargar rango fechas
    Scenario Outline: Descarga de reporte de solicitudes segun rango de fechas
        When se oprima el boton de descarga
        And se seleccione una "<fecha_inicio>"
        And se seleccione una "<fecha_final>"
        And se prima el boton de descarga
        Then debe generar un informe en excel con los registros de solicitudes entre el rango de fechas seleccionado

        Examples:
            | fecha_inicio | fecha_final |
            | 2025-05-22   | 2025-05-22  |
            | 2025-05-12   | 2025-05-22  |


    #Este tiene un bug, si se arregla para la presentacion se muestra del resto no 
    #Descargar rango fechas sin solicitudes
    Scenario Outline: Descarga de reporte sin registros en el rango de fecha
        When se oprima el boton de descarga
        And se seleccione una "<fecha_inicio>"
        And se seleccione una "<fecha_final>"
        And se prima el boton de descarga
        Then debe generar un toat informativo con texto "No hay solicitudes en ese rango de fechas"

        Examples:
            | fecha_inicio | fecha_final |
            | 2025-05-22   | 2025-05-22  |
            | 2025-05-12   | 2025-05-22  |

    #Informacion Solicitud Estado Rechazada
    Scenario: Mostrar informacion de la solicitud en estado Rechazada
        When le de clic en el boton de accion
        Then debera mostrar modal con texto "Solicitud rechazada"


    #Informacion Solicitud Estado Pausada
    Scenario: Mostrar formulario de la solicitud en estado Pausada
        When le de clic en el boton de accion
        Then debera mostrar el formulario de vinculacion con titulo "Verifica y actualiza la información del negocio según los datos registrados en Cámara de Comercio"

    #Informacion Solicitud Estado Exitosa
    Scenario: Mostrar informacion de la solicitud en estado Exitosa
        When le de clic en el boton de accion
        Then debera mostrar modal con texto "Solicitud exitosa"


    #Este tiene un bug, si se arregla para la presentacion se muestra del resto no 
    #Pendiente estado de En Proceso
    Scenario: Mostrar informacion de la solicitud en estado En Proceso 
        When le de clic en el boton de accion
        Then debera mostrar modal con texto "Solicitud en proceso"