<h1>Testing - MOBILE</h1>

Comando para la ejecucion por terminal y ver los reportes cucumber:

```bash
Reemplazar @TAG por el tag de ejecucion del .feature

mvn clean verify -Dcucumber.filter.tags="@TAG"
```

Ejecutar los comandos:

    * mvn clean intall -DskipTests  -> Volver a reimportar las dependencias
    * mvn compile -> para compilar el proyecto

Para modificar las capabilities, ir a la ruta: src/main/java/com/mobile y modificar el archivo MobileDriverManager.java con sus capabilities de su equipo android
Para ver los reportes de cucmber ir a la carpeta: target/site/cucumber-html-reports y abrir en el explorador el archivo overview-features

  
