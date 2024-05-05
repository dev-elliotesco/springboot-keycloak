# Sistema de gestión con autenticación utilizando Keycloak, OAuth 2.0 y Spring Boot

## Descripción

Ese proyecto es una aplicación desarrollada en Java con Spring Boot 
para la gestión de autenticación. La aplicación utiliza Keycloak y 
OAuth 2.0 como proveedor de identidad para  garantizar una 
autenticación robusta y una gestión eficaz de los  roles y 
permisos de usuario. 

### Tecnologías Utilizadas

- Java 17
- Gradle
- Spring Boot
- Spring Security
- Keycloak
- OAuth 2.0

## Requisitos

- Java 17
- [Servidor Keycloak](https://www.keycloak.org/downloads)

## Configuración de Keycloak y OAuth 2.0

1. Configura un reino en Keycloak.
2. Crea un cliente para tu aplicación en Keycloak.
3. Configura el flujo de autenticación y el protocolo OAuth 2.0 en Keycloak para el cliente de tu aplicación.
4. Obtén el `clientId` y `clientSecret` de tu cliente.
5. Configura las propiedades de Keycloak en el archivo `application.properties` (ver sección "Configuración de la Aplicación").

## Configuración de la Aplicación

En el archivo `application.properties`, asegúrate de configurar las siguientes variables de entorno con los valores correspondientes:

```properties
keycloak.realm=${KEYCLOAK_REALM}
keycloak.auth-server-url=${KEYCLOAK_AUTH_SERVER_URL}
keycloak.resource=${KEYCLOAK_RESOURCE}
keycloak.credentials.secret=${KEYCLOAK_CLIENT_SECRET}
# Otras propiedades de configuración de Keycloak
```

## Ejecución
Para ejecutar la aplicación localmente, sigue estos pasos:

* Clona este repositorio.
* Configura Keycloak y OAuth 2.0 según las instrucciones anteriores.
* Ejecuta en la raíz del proyecto: 
```
./gradlew bootRun
```