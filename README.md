# Proyecto Final para CoderHouse de Hector Berrutti -Sistema de Facturación

Este proyecto es un sistema de facturación desarrollado en Java utilizando Spring Boot. Permite gestionar clientes, productos, y la creación de facturas con sus respectivos detalles.

## **Características**

- **Gestión de Clientes:** Crear, leer, actualizar y eliminar clientes.
- **Gestión de Productos:** Crear, leer, actualizar y eliminar productos.
- **Compra de Productos:** Al efectuar la compra se genera una factura con detalles de productos y cálculo automático del total.
- **Consulta de Facturas:** Obtener el detalle de todas las facturas o una factura específica por su ID.

## **Estructura del Proyecto**

- **Models:** Contiene las clases de entidad `Cliente`, `Producto`, `Factura`, y `DetalleFactura`.
- **DTOs:** Clases de transferencia de datos, como `FacturaDTO` y `DetalleFacturaDTO`.
- **Repositories:** Interfaces que extienden `JpaRepository` para la persistencia de datos en los modelos.
- **Services:** Servicios que contienen la lógica de negocio.
- **Controllers:** Controladores que manejan las peticiones HTTP.

## **Requisitos Previos**

- Java 11 o superior
- Maven 3.6.3 o superior
- MySQL (o cualquier base de datos compatible)

## **Configuración del Entorno**

1. **Clonar el Repositorio:**

bash

git clone https://github.com/tu-repositorio/sistema-facturacion.git

cd sistema-facturacion


## **Configurar la Base de Datos**
Crea una base de datos en MySQL y actualiza las credenciales en:
src/main/resources/application.properties

Properties:

spring.datasource.url=jdbc:mysql://localhost:3306/nombre_basedatos

spring.datasource.username=tu_usuario

spring.datasource.password=tu_contraseña

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update

- **Alternativa:** Dentro de la carpeta resources, existe la carpeta sql, la cual contiene un script inicial donde se podra generar en forma automatica la base de datos, la cual ya incluye clientes y productos de ejemplo.

## **Instalar Dependencias y Compilar el proyecto**
Bash

mvn clean install

## **Ejectuar la aplicacion**
Bash

mvn spring-boot:run

## **Puntos de Acceso API**
- **Clientes:**

Crear Cliente: POST /api/v1/clientes

Obtener Clientes: GET /api/v1/clientes

Obtener Cliente por ID: GET /api/v1/clientes/{id}

Actualizar Cliente: PUT /api/v1/clientes/{id}

Eliminar Cliente: DELETE /api/v1/clientes/{id}

- **Productos:**

Crear Producto: POST /api/v1/productos

Obtener Productos: GET /api/v1/productos

Obtener Producto por ID: GET /api/v1/productos/{id}

Actualizar Producto: PUT /api/v1/productos/{id}

Eliminar Producto: DELETE /api/v1/productos/{id}

- **Compras:**

Crear una compra: POST /api/v1/compras

- **Facturas:**

Obtener Facturas con detalles: GET /api/v1/facturas

Obtener Factura por ID con detalle: GET /api/v1/facturas/{id}

Eliminar Factura: DELETE /api/v1/facturas/{id}

## **Licencia**
Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo LICENSE para obtener más detalles.

