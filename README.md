# Tul Shopping Cart

_Servicio que expone 9 endpoints para un carrito de compras._

_Para mas información ver: [Prueba Backend Spring.pdf](./docs/Prueba%20backend%20-%20Spring.pdf)_

## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para pruebas._

### Pre-requisitos 📋

_Herramientas necesarias para correr la aplicación_

```
git version 2.24.3
Gradle 7.1
Kotlin 1.4.31
java 11.0.10 2021-01-19 LTS (JDK 11)
```

### Construcción 🔧

+ Abrir una terminal y realizar los siguiente pasos.

```
git clone https://github.com/gustavo-9189/tul-shopping-cart.git
cd tul-shopping-cart
gradle build
```
+ _gradle build_ construirá la aplicación y ejecutará los tests unitarios.

### Correr la aplicación (local) ⚙️

_Desde una terminal, dentro del directorio del proyecto. Realizar los siguientes pasos_

```
gradle bootRun
```
+ Para saber el estado de salud de la aplicación, ir a: http://localhost:8080/actuator/health
+ Para probar la aplicación local, ir a: http://localhost:8080/swagger-ui.html

### Pruebas con Insomnia REST
_Insomnia es un cliente REST, con el cual se podran realizar pruebas a la API desplegada_
+ Descargarse la herramienta desde https://insomnia.rest/download
+ Instalarla e importar el archivo json [TulShoppingCart.json](./docs/TulShoppingCart.json)
+ Ir a Preferences -> Data -> Import Data

## Autor ✒️

* **Gustavo Martínez** - [gustavo-9189](https://github.com/gustavo-9189)