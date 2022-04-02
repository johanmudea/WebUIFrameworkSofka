# language: es
  @FeatureName:agregarProducto
  Característica: carrito Compras
    Como comprador registrado
    necesito compra en la tienda online
    para poder utilizar la plataforma

  @ScenarioName:AgregarVestido
  Escenario: Agregar vestido
    Dado que soy un comprador registrado en la zona de vestidos
    Cuando el cliente agrega producto vestido al carrito
    Entonces como resultado mostrara mensaje de confirmacion.

  @ScenarioName:AgregarCamiseta
  Escenario: Agregar camiseta
    Dado que soy un comprador registrado en la zona de camisetas
    Cuando adiciono producto al carrito
    Entonces mostrara mensaje de confirmacion en pantalla.