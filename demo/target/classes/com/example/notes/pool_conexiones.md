# Pool de conexiones

Un pool de conexiones (o connection pool) es una técnica utilizada en desarrollo backend para gestionar eficientemente las 
conexiones a una base de datos. 

En lugar de abrir y cerrar una conexión cada vez que una aplicación necesita acceder a la base de datos, se mantiene un conjunto de 
conexiones abiertas que pueden ser reutilizadas por múltiples hilos o peticiones.

### Ventajas

- Rendimiento: Evita el coste de crear y destruir conexiones repetidamente.

- Escalabilidad: Permite atender muchas peticiones simultáneas sin saturar la base de datos.

- Control: el pool evita que tu aplicación abra miles de conexiones sin límite y derribe al servidor de base de datos.tc.

## ¿Cómo funciona?

1. Al iniciar la aplicación, se crean varias conexiones y se guardan en el pool.

2. Cuando una parte del código necesita acceder a la base de datos, toma una conexión del pool.

3. Al terminar, la devuelve al pool (no se cierra).

4. Si todas las conexiones están ocupadas, el sistema espera o crea nuevas, según la configuración.

##  Ejemplo en Java con HikariCP

````java
HikariConfig config = new HikariConfig();
config.setJdbcUrl("jdbc:mysql://localhost:3306/mi_base");
config.setUsername("usuario");
config.setPassword("contraseña");
config.setMaximumPoolSize(10);

HikariDataSource dataSource = new HikariDataSource(config);

try (Connection conn = dataSource.getConnection()) {
    // Usar la conexión para ejecutar consultas
}
````
    Al usar try-with-resources, la conexión se devuelve automáticamente al pool, no se cierra realmente.













