Feature: Probar la funcionalidad de la pagina de compras

  Scenario Outline: Navegar por la web
    Given El usuario esta en la pagina home
    And da clic en BEST SELLERS
    And da clic el ultimo resultado
    Then se muestra la informacion del Printed Dress
    And da clic en simbolo mas para subir Quantity a <cantidad>
    And selecciona talla "<tamano>"
    And clic en Add to cart y clic en Proceed to checkout
    Then se muestra el resumen de la compra
    And se muestra la pagina de Authentication
    And el usuario se logea con "<user>" y "<pass>"
    And el usuario esta logeado y se confirman las direcciones de envio y facturacion dando clic en proceed
    Then se muestra detalle del envio
    And el usuario confirma los terminos de servicio
    And el usuario paga por bankwire haciendo clien en la opcion
    Then se muestra la pagina de detalle de bank wire
    And el usuario confirma la orden
    Then se muestra la pagina de Order Confirmation

    Examples: 
      | cantidad | tamano | user          | pass  |
      |        1 | L      | yada@yada.com | pass1 |
      # |        5 | M      | yada@yada.com | pass1 |
      # |       10 | S      | yada@yada.com | pass1 |
     # |        8 | M      |               |       |
