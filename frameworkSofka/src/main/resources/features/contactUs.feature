# language: es
  @FeatureName:mensajeSoporte
  Característica: carrito Compras
    Como comprador registrado
    necesito compra en la tienda online
    para poder utilizar la plataforma

  @ScenarioName:ContactarServicioAlCliente
  Escenario: Contactar con soporte
    Dado que estoy en la seccion de contacto
    Cuando el cliente diligencia la informacion
    Entonces como resultado mostrara mensaje de confirmacion.

  @ScenarioName:MensajeFallidoPorEmail
  Escenario: MensajeSinMail
    Dado  que estoy en  contacto
    Cuando no diligencio el email
    Entonces mostrara mensaje de error en pantalla.