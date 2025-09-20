## javax.sql

javax.sql es una extension avanzada de la api de JDBC es decir, implementa las clases de java.
sql con interfaces avanzadas, ya que esta pensada para entorno mas complejos como java EE

## Diferencia entre java.sql y javax.sql

| Paquete   | Propósito principal                                                                      |
|-----------|------------------------------------------------------------------------------------------|	
| java.sql	| Proporciona la API básica de JDBC para conectarse y operar con bases de datos.           |
|-----------|------------------------------------------------------------------------------------------|   
| javax.sql |	Es una extensión avanzada de JDBC, pensada para entornos más complejos (como Java EE). |
|------------------------------------------------------------------------------------------------------|

## ¿Qué contiene cada uno?

java.sql incluye:

- Interfaces básicas:

    - Connection
    - Statement
    - PreparedStatement
    - ResultSet
    - DriverManager

Funciones esenciales para ejecutar consultas, manejar transacciones, etc.

---

javax.sql extiende con:

- Interfaces avanzadas:

    - DataSource: alternativa a DriverManager, ideal para pool de conexiones.
    - ConnectionPoolDataSource: para gestionar pools directamente.
    - RowSet: permite trabajar con datos desconectados (como si fueran objetos Java).
    - XADataSource: para transacciones distribuidas (JTA).
    - PooledConnection: conexión reutilizable en entornos de servidor.