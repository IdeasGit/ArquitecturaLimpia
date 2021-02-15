Feature: Acceptance Test for Consulta de movimeintos

  Background:
    * url 'http://localhost:9080/account/movements'

  Scenario: Consultar de movimientos
    Given request {"data": {"pagination": {"size": 20,"key": 1},"account": {"type": "CUENTA_CORRIENTE","number": "10115447858"},"office": {"code": "406","name": "Direccion General"}}}
    When method post
    Then status 200
    And match $.data[0].account.balances.available == 25000000

  Scenario: Consultar de movimientos status 500
    Given request {"": {"pagination": {"size": 20,"key": 1},"account": {"type": "CUENTA_CORRIENTE","number": "10115447858"},"office": {"code": "406","name": "Direccion General"}}}
    When method post
    Then status 500
