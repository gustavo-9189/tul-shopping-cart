# Tul Shopping Cart

_Servicio que expone 9 endpoints para un carrito de compras._

_Para mas informaci贸n ver: [Prueba Backend Spring.pdf](./docs/Prueba%20backend%20-%20Spring.pdf)_

## Comenzando 馃殌

_Estas instrucciones te permitir谩n obtener una copia del proyecto en funcionamiento en tu m谩quina local para pruebas._

### Pre-requisitos 馃搵

_Herramientas necesarias para correr la aplicaci贸n_

```
git version 2.24.3
Gradle 7.1
Kotlin 1.4.31
java 11.0.10 2021-01-19 LTS (JDK 11)
```

### Construcci贸n 馃敡

+ Abrir una terminal y realizar los siguiente pasos.

```
git clone https://github.com/gustavo-9189/tul-shopping-cart.git
cd tul-shopping-cart
gradle build
```
+ _gradle build_ construir谩 la aplicaci贸n y ejecutar谩 los tests unitarios.

### Correr la aplicaci贸n (local) 鈿欙笍

_Desde una terminal, dentro del directorio del proyecto. Realizar los siguientes pasos_

```
gradle bootRun
```
+ Para saber el estado de salud de la aplicaci贸n, ir a: http://localhost:8080/actuator/health
+ Para probar la aplicaci贸n local, ir a: http://localhost:8080/swagger-ui.html

### Pruebas con Insomnia REST
_Insomnia es un cliente REST, con el cual se podran realizar pruebas a la API desplegada_
+ Descargarse la herramienta desde https://insomnia.rest/download
+ Instalarla e importar el archivo json [TulShoppingCart.json](./docs/TulShoppingCart.json)
+ Ir a Preferences -> Data -> Import Data

## Autor 鉁掞笍

* **Gustavo Mart铆nez** - [gustavo-9189](https://github.com/gustavo-9189)