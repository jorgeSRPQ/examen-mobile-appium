#language: es
@login
Característica: Inicio de sesion con el app Saucelabs Demo
  Como usuario ya registrado
  Quiero ingresar mis credenciales
  Para poder usar la aplicacion

  Antecedentes:
    Dado que me encuentro en la aplicacion SauceLabsDemo

  @login_sauce_exitoso
  Esquema del escenario: Caso 01 - Inicio de sesión exitoso con credenciales correctas
    Cuando ingreso al Menu "Log In"
    Y me muestra la pantalla de "Login"
    E ingreso mi usuario "<sUserName>"
    E ingreso mi password "<sUserPassword>"
    Y presiono Login
    Entonces deberia mostrarme la pantalla de catalogo de productos "Products"
    Ejemplos:
      | sUserName       | sUserPassword |
      | bob@example.com | 10203040      |

