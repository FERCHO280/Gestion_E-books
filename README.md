# API RESTful Avanzada - Sistema de Gestión de E-Books

**Estudiante:** Fernando Javier Gaibor Llango
**Institución:** Universidad Internacional del Ecuador (UIDE)
**Asignatura:** Programación Orientada a Objetos

## Justificación y Alcance del Proyecto
Este sistema backend fue desarrollado para superar las limitaciones de un CRUD convencional. Su objetivo es gestionar el acceso a libros digitales priorizando la seguridad y el manejo de solicitudes concurrentes.

**Limitaciones actuales:**
El enfoque es 100% backend (lógica de negocio y ciberseguridad defensiva), por lo que no cuenta con interfaz gráfica de usuario ni pasarela de pagos implementada.

**Implicaciones a Futuro:**
La arquitectura está preparada para escalar e integrarse con tecnología Blockchain, lo que permitiría que cada licencia de lectura funcione como un *Smart Contract* inalterable.

## ️ Diagrama de Flujo y Arquitectura
El siguiente diagrama ilustra cómo interactúan los servicios, garantizando encapsulación estricta y protección mediante concurrencia.

```mermaid
graph TD
    A[Cliente / Petición HTTP] -->|JSON| B(ApiController)
    B -->|Manejo de Errores| C{Bloques Try-Catch}
    C -->|Autenticación| D[AutenticacionService]
    D -->|JWT Inmutables| E[Sesión Segura]
    C -->|Estadísticas & Lógica| F[CatalogoService]
    F -->|Prevención de Nulos| G[Uso de Optional y Records]
    F -->|Concurrencia Activa| H[(HikariCP Pool SQL)]