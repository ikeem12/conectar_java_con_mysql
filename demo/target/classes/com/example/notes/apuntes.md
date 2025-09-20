# Conexion a MySQL con Java

Para conectar Java con MySQL, lo más común es usar JDBC (Java Database Connectivity) junto con 
el MySQL Connector/J, que es el driver oficial.

## ¿Que es es JDBC?

JDBC (Java Database Connectivity) es la API estándar de Java que permite a las aplicaciones 
comunicarse con bases de datos relacionales como MySQL, PostgreSQL, Oracle, etc. Es como el 
traductor entre el código Java y el sistema gestor de base de datos (SGBD).

### ¿Qué hace JDBC?

JDBC se encarga de:

- Establecer la conexión con la base de datos.
- Enviar consultas SQL desde Java.
- Recibir resultados y procesarlos.
- Gestionar errores y excepciones de base de datos.

### Arquitectura de JDBC

JDBC tiene dos capas principales:


|Capa        | Función                                                                    |  
|------------|----------------------------------------------------------------------------|
|JDBC API    |	Interfaces Java (Connection, Statement, ResultSet, etc.)                  |
|------------|----------------------------------------------------------------------------|
|JDBC Driver |	Implementación específica para cada base de datos (MySQL, Oracle, etc.)   |
|-----------------------------------------------------------------------------------------|

Por ejemplo, el driver mysql-connector-j traduce las llamadas JDBC a comandos que MySQL 
entiende.

## ¿Qué se necesita para conectar Java con una base de datos?

1. JDBC API

- Es el conjunto de interfaces y clases estándar que Java ofrece para interactuar con bases de 
datos.

- Define cómo el código debe estructurarse: cómo abrir una conexión, ejecutar una consulta, 
leer resultados, etc.

Ejemplos: Connection, Statement, ResultSet, PreparedStatement.

    Es como tener un contrato que dice: “si quieres hablar con una base de datos, usa estos 
    métodos y estructuras”.

---

2. JDBC Driver

- Es la implementación concreta de ese contrato, hecha por el fabricante del SGBD (como MySQL, 
PostgreSQL, Oracle).

- Traduce las llamadas de la API a comandos que la base de datos entiende.

Ejemplo: mysql-connector-j para MySQL.

Es como el traductor que convierte lo que dices en Java al idioma que habla MySQL.

## Diferencia entre java.sql y javax.sql

- **java.sql**:
    - Es el núcleo de JDBC, incluido desde las primeras versiones de Java SE.
    - Contiene clases esenciales como Connection, DriverManager, Statement, ResultSet, etc.
    - Se usa para tareas básicas de conexión, ejecución de consultas y manejo de resultados.

- **javax.sql**:
    - Es una extensión de JDBC, originalmente pensada para Java EE (ahora Jakarta EE).
    - Incluye interfaces más avanzadas como DataSource, RowSet, ConnectionPoolDataSource, etc.
    - Se usa cuando SE necesita pool de conexiones, acceso más flexible o integración con servidores de aplicaciones.