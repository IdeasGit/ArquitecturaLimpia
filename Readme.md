# Proyecto Clean Architecture - Consulta de saldos mas movimientos de una cuenta

## Descripcion

Permite consultar los saldos mas movimientos de una cuenta especifica

# Arquitectura

## Domain

Es el módulo más interno de la arquitectura, pertenece a la capa del dominio y encapsula la lógica y reglas del negocio mediante modelos y entidades del dominio.

## Usecases

Este módulo gradle perteneciente a la capa del dominio, implementa los casos de uso del sistema, define lógica de aplicación y reacciona a las invocaciones desde el módulo de entry points, orquestando los flujos hacia el módulo de entities.

## Infrastructure

### Driven Adapters

Los driven adapter representan implementaciones externas a nuestro sistema, como lo son conexiones a servicios rest,
soap, bases de datos, lectura de archivos planos, y en concreto cualquier origen y fuente de datos con la que debamos
interactuar.

### Entry Points

Los entry points representan los puntos de entrada de la aplicación o el inicio de los flujos de negocio.


## Swagger
/applications/app-service/src/mail/resource/Taller_CA_Account_Movements_1.0.0.yaml

##SandBox
Saldos: https://retrievebalance.getsandbox.com/retrieveBalance
Movimientos: https://retrievebalance.getsandbox.com/retrieveTransaction