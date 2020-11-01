Feature: Mi Movistar Flujo de Recargas

  @Test1 @Regresion
  Scenario Outline: Generación de TOKEN URL

    Given se genera la URL mediante el API_TEST_recargas

    Examples:
      | caso_prueba |
      |           1 |

  @Test2
  Scenario Outline: Recargas en Mi Movistar MOVIL (Ingresando URL manualmente en Excel)

    Given se ingresa en la URL el token generado "<caso_prueba>"
    And se ingresa el numero celular "<caso_prueba>"
    And monto a recargar "<caso_prueba>"
    And se da click en el boton Continuar
    When se ingresa el email "<caso_prueba>" y se da click en continuar
    And se ingresa el numero de tarjeta "<caso_prueba>"
    And se ingresa el mes de vencimiento "<caso_prueba>"
    And se ingresa el anio de vencimiento "<caso_prueba>"
    And se ingresa el codigo de verificacion "<caso_prueba>"
    And se da click en el boton Pagar
    Then se verifica que se hizo la recarga correcta.

    Examples:
      | caso_prueba |
      |           1 |


  @Test3
  Scenario Outline: Recargas en Mi Movistar Completo MOVIL (Generando automáticamente Token URL)

    Given se genera la URL mediante el API_TEST_recargas
    Given se ingresa en la URL el token generado "<caso_prueba>"
    And se ingresa el numero celular "<caso_prueba>"
    And monto a recargar "<caso_prueba>"
    And se da click en el boton Continuar
    When se ingresa el email "<caso_prueba>" y se da click en continuar
    And se ingresa el numero de tarjeta "<caso_prueba>"
    And se ingresa el mes de vencimiento "<caso_prueba>"
    And se ingresa el anio de vencimiento "<caso_prueba>"
    And se ingresa el codigo de verificacion "<caso_prueba>"
    And se da click en el boton Pagar
    Then se verifica que se hizo la recarga correcta.

    Examples:
      | caso_prueba |
      |           1 |

  @Test4
  Scenario Outline: Recargas en Mi Movistar MOVIL (Ingresando URL manualmente en Excel 4 veces seguidas)

    Given se ingresa en la URL el token generado "<caso_prueba>"
    And se ingresa el numero celular "<caso_prueba>"
    And monto a recargar "<caso_prueba>"
    And se da click en el boton Continuar
    When se ingresa el email "<caso_prueba>" y se da click en continuar
    And se ingresa el numero de tarjeta "<caso_prueba>"
    And se ingresa el mes de vencimiento "<caso_prueba>"
    And se ingresa el anio de vencimiento "<caso_prueba>"
    And se ingresa el codigo de verificacion "<caso_prueba>"
    And se da click en el boton Pagar
    Then se verifica que se hizo la recarga correcta.

    Examples:
      | caso_prueba |
      |           1 |
      |           2 |
      |           3 |
      |           4 |

    @Test5
    Scenario Outline: Bloqueo Por Tarjeta Maximo 3 exitosas MOVIL (Ingresando URL manualmente en Excel 4 veces seguidas)

      Given se ingresa en la URL el token generado "<caso_prueba>"
      And se ingresa el numero celular "<caso_prueba>"
      And monto a recargar "<caso_prueba>"
      And se da click en el boton Continuar
      When se ingresa el email "<caso_prueba>" y se da click en continuar
      And se ingresa el numero de tarjeta "<caso_prueba>"
      And se ingresa el mes de vencimiento "<caso_prueba>"
      And se ingresa el anio de vencimiento "<caso_prueba>"
      And se ingresa el codigo de verificacion "<caso_prueba>"
      And se da click en el boton Pagar
      Then se verifica que se hizo la recarga correcta.

      Examples:
        | caso_prueba |
        |           1 |
        |           2 |
        |           3 |
        |           4 |

      @Test6 @Regresion
      Scenario Outline: Recargas en Mi Movistar WEB PUBLICA (Generando automáticamente Token 2 URL)

        Given se genera la URL mediante el API_TEST_recargasVersion2
        Given se ingresa en la URL el token generado "<caso_prueba>"
        When se ingresara el email "<caso_prueba>" y se da click en continuar
        And se ingresa el numero de tarjeta "<caso_prueba>"
        And se ingresa el mes de vencimiento "<caso_prueba>"
        And se ingresa el anio de vencimiento "<caso_prueba>"
        And se ingresa el codigo de verificacion "<caso_prueba>"
        And se da click en el boton Pagar
        Then se verifica que se hizo la recarga correcta.

        Examples:
          | caso_prueba |
          |           1 |



