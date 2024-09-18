@AllTest

Feature: agregar productos

  @AddProduct
  Scenario Outline: agrego productos al carrito
    Given el Usuario esta en la pagina de demoblaze
    When escojo productos para el carro
    And verifica la compra de los articulos
    Then llena el formulario de compra con los siguientes datos "<Name>", "<Country>", "<City>", "<CreditCard>", "<Month>", "<Year>"

    Examples:
      | Name             | Country | City  | CreditCard       | Month | Year |
      | Roberth Zambrano | Ecuador | Quito | 1234567812345678 | 09    | 2025 |
