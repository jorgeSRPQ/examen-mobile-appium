#language: es
@carrito
Característica: Validación del carrito de compras en SauceLabs Demo

  Como usuario de la tienda online
  Quiero agregar productos al carrito
  Para validar que el carrito se actualice correctamente

  Esquema del escenario: Validar carrito de compras por producto
    Dado que me encuentro en la aplicacion SauceLabsDemo
    Y valido que carguen correctamente los productos en la galeria
    Cuando agrego <UNIDADES> del siguiente producto "<PRODUCTO>"
    Entonces valido el carrito de compra actualice correctamente para el producto "<PRODUCTO>"

    Ejemplos:
      | PRODUCTO                 | UNIDADES |
      | Sauce Labs Backpack      | 1        |
      | Sauce Labs Bolt T-Shirt  | 1        |
      | Sauce Labs Fleece Jacket | 2        |