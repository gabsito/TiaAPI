# TiaAPI

## Configuración y Ejecución del Proyecto

Este documento proporciona instrucciones para configurar y ejecutar el proyecto TiaAPI.

### Prerrequisitos

Asegúrese de tener instalados los siguientes componentes:

- Java Development Kit (JDK) 17
- Maven
- MySQL

### Configuración de la Base de Datos

1. Cree una base de datos en MySQL llamada tia.
2. Configure las variables de conexión de la base de datos en el archivo `application.properties`. Este archivo se encuentra en el directorio `src/main/resources`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nombre_de_tu_base_de_datos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

### Ejecución del Proyecto

1. Clone el repositorio del proyecto:

    ```sh
    git clone https://github.com/gabsito/TiaAPI.git
    ```

2. Navegue al directorio del proyecto:

    ```sh
    cd TiaAPI
    ```

3. Compile y empaquete el proyecto usando Maven:

    ```sh
    mvn clean package
    ```

4. Ejecute la aplicación:

    ```sh
    java -jar target/tiaapi-0.0.1-SNAPSHOT.jar
    ```

### Notas

- Asegúrese de que el servidor MySQL esté en funcionamiento antes de ejecutar la aplicación.
- Puede ajustar las configuraciones adicionales en el archivo `application.properties` según sea necesario.

¡Listo! Ahora debería poder configurar y ejecutar el proyecto TiaAPI correctamente.